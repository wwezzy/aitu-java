public class Main {
    public static void main(String[] args) {
        // 1. Создаем университет
        University myUni = new University("Astana IT University");

        // 2. Создаем профессоров
        Professor prof1 = new Professor("Khaimuldin", "k.khaimuldin@aitu.kz", "Computer Science", 10);
        Professor prof2 = new Professor("Walter White", "w.white@aitu.kz", "Chemistry", 20);

        myUni.addProfessor(prof1);
        myUni.addProfessor(prof2);

        // 3. Создаем курсы и привязываем профессоров
        myUni.addCourse(new Course("SE2324", "Object-Oriented Programming", 5, prof1));
        myUni.addCourse(new Course("MATH110", "Calculus I", 4, null)); // Пока без профессора
        myUni.addCourse(new Course("CS101", "Introduction to CS", 6, prof1));

        // 4. Демонстрация работы (Data Pool logic)
        myUni.printAllInfo();

        System.out.println();
        // Поиск
        Course found = myUni.findCourseByCode("SE2324");
        System.out.println("Search Result: " + (found != null ? found : "Not Found"));

        System.out.println();
        // Фильтрация
        myUni.printHeavyCourses(5);

        System.out.println();
        // Сортировка
        myUni.sortCoursesByCredits();
    }
}