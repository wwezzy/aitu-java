public class University {

    // Attributes (fields)
    private String name;
    private String city;
    private int yearFounded;
    private int totalStudents;
    private int ranking;

    // No-argument constructor
    public University() {
        this.name = "Unknown University";
        this.city = "Unknown City";
        this.yearFounded = 0;
        this.totalStudents = 0;
        this.ranking = 0;
    }

    // Parameterized constructor
    public University(String name, String city, int yearFounded, int totalStudents, int ranking) {
        this.name = name;
        this.city = city;
        this.yearFounded = yearFounded;
        this.totalStudents = totalStudents;
        this.ranking = ranking;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    // Method: increase number of students
    public void increaseStudents(int amount) {
        if (amount > 0) {
            totalStudents = totalStudents + amount;
        }
    }

    // Method: check if university is in top 100
    public boolean isTopUniversity() {
        return ranking > 0 && ranking <= 100;
    }

    // Method: print university info
    public void printInfo() {
        System.out.println("University: " + name
                + " in " + city
                + ", founded in " + yearFounded
                + ", students: " + totalStudents
                + ", ranking: " + ranking);
    }
}
