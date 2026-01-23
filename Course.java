public class Course {
    private int credits;
    private String title;
    private String description;
    public Course(int credits, String title, String description) {
        this.credits = credits;
        this.title = title;
        this.description = description;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
    return description;}
    public void setDescription(String description) {
        this.description = description;
    }

}