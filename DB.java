import java.sql.*; // Импортируем всё сразу (Connection, Statement, ResultSet и т.д.)

public class DB {

    // --- 1. ПОДКЛЮЧЕНИЕ ---
    public Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/simpledb";
            String user = "postgres";
            String password = "Allazhar072007";

            conn = DriverManager.getConnection(url, user, password);
            // System.out.println("Успешное подключение к PostgreSQL!"); // Можно закомментировать, чтобы не мешало выводу

        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
        return conn;
    }

    // --- 2. ДОБАВЛЕНИЕ (INSERT) ---
    public void addProfessor(Professor professor) {
        String sql = "INSERT INTO professors (id, name, surname, subject) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Подставляем данные из объекта professor вместо знаков вопроса
            pstmt.setInt(1, professor.getId());
            pstmt.setString(2, professor.getName());
            pstmt.setString(3, professor.getSurname());
            pstmt.setString(4, professor.getSubject());

            pstmt.executeUpdate(); // Отправляем в базу
            System.out.println("Professor added to database.");

            conn.close(); // Закрываем соединение
        } catch (SQLException e) {
            System.out.println("Error when try to add " + e.getMessage());
        }
    }

    // --- 3. ВЫВОД (SELECT) - ТО, ЧТО ТЕБЕ НУЖНО ---
    public void getProfessors() {
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement(); // Создаем "посыльного" для запросов

            String sql = "SELECT * FROM professors"; // Запрос: дай всё из таблицы professors
            ResultSet rs = stmt.executeQuery(sql);   // rs - это таблица с результатами

            System.out.println("\n--- 📋 СПИСОК ИЗ БАЗЫ ДАННЫХ (PostgreSQL) ---");

            // rs.next() переходит к следующей строке. Пока строки есть - цикл работает.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String subject = rs.getString("subject");

                System.out.println("ID: " + id + " | " + name + " " + surname + " (" + subject + ")");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при чтении: " + e.getMessage());
        }
    }
}