import java.util.Scanner; // 1. Важный импорт для сканера

public class Main {
    public static void main(String[] args) {
        // --- ЧАСТЬ 1: Проверка подключения к базе данных (Assignment 3) ---
        System.out.println("--- 1. Database Connection Check ---");
        DB db = new DB();
        db.connect();

        // --- ЧАСТЬ 2: Интерактивное создание данных ---
        Scanner in = new Scanner(System.in); // Создаем сканер
        System.out.println("\n--- Введите данные нового профессора ---");

        // Спрашиваем данные по очереди
        System.out.print("Введите ID: ");
        int id = in.nextInt();

        System.out.print("Введите Имя (Name): ");
        String name = in.next();

        System.out.print("Введите Фамилию (Surname): ");
        String surname = in.next();

        System.out.print("Введите Предмет (Subject): ");
        String subject = in.next();
        // Совет: вводи предмет одним словом (например, "Math"), чтобы сканер не запутался

        // Создаем профессора из того, что ввел пользователь
        Professor prof1 = new Professor(name, surname, id, subject);

        // Сохраняем его в базу данных
        db.addProfessor(prof1);

        // --- Продолжаем работу с университетом (Assignment 2) ---
        University aitu = new University();

        // Создаем остальных (студентов пока оставим как есть для примера)
        Student st1 = new Student("Zara", "Ali", 102, 3.5);
        Student st2 = new Student("Amir", "K.", 101, 3.8);

        // Создаем курсы
        Course math = new Course(5, "Mathematics", "Advanced Calculus");
        Course javaCourse = new Course(6, "Java Programming", "OOP and Streams");

        // Добавляем всех в список университета
        aitu.addPerson(st1);
        aitu.addPerson(st2);
        aitu.addPerson(prof1); // Добавляем того самого профессора, которого ввели

        aitu.addCourse(math);
        aitu.addCourse(javaCourse);

        // --- ЧАСТЬ 3: Тестирование методов ---

        // 1. Вывод полной информации
        System.out.println("\n--- 2. Initial List ---");
        aitu.printUniversityInfo();

        // 2. Сортировка по имени
        System.out.println("\n--- 3. Sorting by Name ---");
        aitu.sortPeopleByName();
        aitu.printUniversityInfo();

        // 3. Фильтрация (только студенты)
        aitu.showOnlyStudents();

        // 4. Поиск по ID
        System.out.println("\n--- 5. Searching for ID " + id + " ---");
        // Ищем того, кого только что добавили
        Person found = aitu.findPersonById(id);
        if (found != null) {
            System.out.println("Found: " + found.getName() + " (" + found.getRole() + ")");
        } else {
            System.out.println("User not found.");
        }
    }
}