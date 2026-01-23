public class Student extends Person {
    private double gpa;
    public Student(String name, String surname,  int id, double gpa) {
        super(name, surname, id);
        this.gpa = gpa;

    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getRole () {
        return "Student";
    }
    @Override
    public String toString() {
        return super.toString() + "\nGPA: " + gpa;
    }
}
