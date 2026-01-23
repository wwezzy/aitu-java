import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
public class University {
 ArrayList<Person> people;
 ArrayList<Course> courses;

 public University(){
     this.people = new ArrayList<>();
     this.courses = new ArrayList<>();
 }
 public void addPerson(Person person){
     this.people.add(person);
 }
    public void addCourse(Course course) {
        this.courses.add(course);
    }
 public void printUniversityInfo() {
        for (Person p : people) {
            System.out.println(p);
        }
        System.out.println("\n[University Courses]");
        for (Course c : courses) {
            System.out.println("Title: " + c.getTitle() + ", Credits: " + c.getCredits());
        }
    }
    public void sortPeopleByName() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
               return p1.getName().compareTo(p2.getName());
            }
        });
        System.out.println("List of people after sorting:");
    }
    // 1. Фильтрация: Показываем только студентов
    public void showOnlyStudents() {
        System.out.println("\n--- Students Only ---");
        for (Person p : people) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    // 2. Поиск: Ищем человека по ID
    public Person findPersonById(int id) {
        for (Person p : people) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Если не нашли
    }



}