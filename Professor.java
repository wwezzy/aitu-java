public class Professor extends Person {
    private String department;
    private int yearsOfExperience;

    public Professor(String name, String email, String department, int yearsOfExperience) {
        super(name, email); // Вызов конструктора родителя
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    // Требование: Полиморфизм (переопределение метода родителя)
    @Override
    public String toString() {
        // super.toString() вызовет метод из Person
        return "Professor [" + super.toString() + ", Dept: " + department + ", Exp: " + yearsOfExperience + " years]";
    }
}