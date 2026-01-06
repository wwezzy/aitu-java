import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    private String name;
    // Data Pool: списки хранятся внутри университета
    private List<Course> courses;
    private List<Professor> professors;

    public University(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    // Методы добавления
    public void addProfessor(Professor p) {
        professors.add(p);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    // --- SEARCHING (Поиск) ---
    public Course findCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    // --- FILTERING (Фильтрация) ---
    public void printHeavyCourses(int minCredits) {
        System.out.println("--- Filtering: Courses with >= " + minCredits + " credits ---");
        for (Course c : courses) {
            if (c.getCredits() >= minCredits) {
                System.out.println(c); // Тут сработает toString()
            }
        }
    }

    // --- SORTING (Сортировка) ---
    public void sortCoursesByCredits() {
        // Используем Comparator
        courses.sort(Comparator.comparingInt(Course::getCredits).reversed());
        System.out.println("--- Sorted Courses by Credits (Desc) ---");
        for (Course c : courses) System.out.println(c);
    }

    public void printAllInfo() {
        System.out.println("Welcome to " + name);
        System.out.println("\n--- Professors List ---");
        for (Professor p : professors) System.out.println(p);

        System.out.println("\n--- Course List ---");
        for (Course c : courses) System.out.println(c);
    }
}