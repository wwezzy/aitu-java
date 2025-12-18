public class Professor {

    // Attributes (fields)
    private String name;
    private String department;
    private String email;
    private int yearsOfExperience;

    // No-argument constructor
    public Professor() {
        this.name = "Unknown";
        this.department = "No department";
        this.email = "no-email@unknown.com";
        this.yearsOfExperience = 0;
    }

    // Parameterized constructor
    public Professor(String name, String department, String email, int yearsOfExperience) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    // New method: change professor's department
    public void changeDepartment(String newDepartment) {
        System.out.println("Professor " + name + " is changing department from "
                + department + " to " + newDepartment);
        this.department = newDepartment; // or setDepartment(newDepartment);
    }

    // Method: check if professor is senior
    public boolean isSenior() {
        return yearsOfExperience >= 10;
    }

    // Method: print professor info
    public void printInfo() {
        System.out.println("Professor: " + name
                + ", department: " + department
                + ", email: " + email
                + ", experience: " + yearsOfExperience + " years");
    }
}
