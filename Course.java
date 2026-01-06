import java.util.Objects;

public class Course implements Comparable<Course> {
    private String code;
    private String title;
    private int credits;
    private Professor professor; // Курс ведет профессор

    public Course(String code, String title, int credits, Professor professor) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.professor = professor;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public Professor getProfessor() { return professor; }

    // Требование: Override toString
    @Override
    public String toString() {
        String profName = (professor != null) ? professor.getName() : "No Professor";
        return String.format("Course %s: %s (%d credits), Taught by: %s", code, title, credits, profName);
    }

    // Требование: Override equals (сравниваем курсы по коду)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    // Для сортировки по умолчанию
    @Override
    public int compareTo(Course other) {
        return this.code.compareTo(other.code);
    }
}