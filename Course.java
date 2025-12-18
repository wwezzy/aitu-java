public class Course {

    // Attributes (fields)
    private String code;
    private String title;
    private int credits;
    private int maxStudents;

    // No-argument constructor (default values)
    public Course() {
        this.code = "UNKNOWN";
        this.title = "No title";
        this.credits = 0;
        this.maxStudents = 0;
    }

    // Parameterized constructor
    public Course(String code, String title, int credits, int maxStudents) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.maxStudents = maxStudents;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    // Method: check if course is heavy (many credits)
    public boolean isHeavyCourse() {
        return credits >= 5;
    }

    // Method: print course info
    public void printInfo() {
        System.out.println("Course: " + code + " - " + title
                + ", credits: " + credits
                + ", max students: " + maxStudents);
    }
}
