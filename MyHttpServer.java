import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MyHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/professors", new ProfessorHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class ProfessorHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Разрешаем запросы с любого сайта (CORS)
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

            // Если браузер просто "спрашивает" разрешения (OPTIONS), говорим OK
            if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            // 1. Если это GET - отдаем список (как раньше)
            if ("GET".equals(exchange.getRequestMethod())) {
                DB db = new DB();
                List<Professor> professors = db.getAllProfessorsList();

                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < professors.size(); i++) {
                    Professor p = professors.get(i);
                    json.append("{")
                            .append("\"id\":").append(p.getId()).append(",")
                            .append("\"name\":\"").append(p.getName()).append("\",")
                            .append("\"surname\":\"").append(p.getSurname()).append("\",")
                            .append("\"subject\":\"").append(p.getSubject()).append("\"")
                            .append("}");
                    if (i < professors.size() - 1) json.append(",");
                }
                json.append("]");

                sendResponse(exchange, json.toString(), 200);
            }

            // 2. Если это POST - принимаем данные и сохраняем!
            else if ("POST".equals(exchange.getRequestMethod())) {
                // Читаем тело запроса (JSON, который прислал сайт)
                InputStream is = exchange.getRequestBody();
                String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                System.out.println("Получен JSON: " + body);

                // --- РУЧНОЙ ПАРСИНГ JSON (Без библиотек это сложно, но мы схитрим) ---
                // Ожидаем: {"id":123, "name":"Test", "surname":"User", "subject":"Math"}
                try {
                    int id = Integer.parseInt(extractValue(body, "id"));
                    String name = extractValue(body, "name");
                    String surname = extractValue(body, "surname");
                    String subject = extractValue(body, "subject");

                    // Сохраняем в базу
                    Professor p = new Professor(name, surname, id, subject);
                    DB db = new DB();
                    db.addProfessor(p);

                    sendResponse(exchange, "{\"status\":\"Saved!\"}", 200);
                } catch (Exception e) {
                    e.printStackTrace();
                    sendResponse(exchange, "{\"error\":\"Bad JSON format\"}", 400);
                }
            } else {
                exchange.sendResponseHeaders(405, -1); // Метод не поддерживается
            }
        }

        // Вспомогательный метод отправки
        private void sendResponse(HttpExchange exchange, String response, int code) throws IOException {
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(code, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }

        // Примитивный метод для вытаскивания значений из JSON-строки
        private String extractValue(String json, String key) {
            String searchKey = "\"" + key + "\":";
            int start = json.indexOf(searchKey);
            if (start == -1) return "";
            start += searchKey.length();

            // Если значение в кавычках (строка)
            if (json.charAt(start) == '"') {
                start++;
                int end = json.indexOf("\"", start);
                return json.substring(start, end);
            }
            // Если число
            else {
                int end = start;
                while (end < json.length() && (Character.isDigit(json.charAt(end)))) {
                    end++;
                }
                return json.substring(start, end);
            }
        }
    }
}