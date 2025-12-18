public class Main {
    public static void main(String[] args) {

        // 1) Create Course objects
        Course course1 = new Course("SE2515", "Intro to Programming", 5, 100);
        Course course2 = new Course("SE2514", "Calculus II", 4, 80);

                
        // 2) Create Professor objects
        Professor prof1 = new Professor("Dexter", "Computer Science",
                "hochuchipsy@uni.kz", 15);
        Professor prof2 = new Professor("Haisenberg", "Math",
                "breakingbad@uni.kz", 7);

        // 3) Create University objects
        University uni1 = new University("Astana IT University", "Astana",
                2019, 5000, 15);
        University uni2 = new University("Some University", "Almaty",
                1995, 8000, 30);

        // 4) Output objects to console
        System.out.println("=== Courses ===");
        course1.printInfo();
        course2.printInfo();

        System.out.println("\n=== Professors ===");

        prof1.printInfo();
        prof2.printInfo();
        // Изменяем департамент у prof1
        System.out.println("\n=== Change professor department ===");
        prof1.changeDepartment("Software Engineering");

        // Снова выводим информацию, чтобы увидеть изменения
        prof1.printInfo();
        System.out.println("\n=== Universities ===");
        uni1.printInfo();
        uni2.printInfo();

        // 5) Compare multiple objects

        // Compare courses by credits
        System.out.println("\n=== Compare courses by credits ===");
        if (course1.getCredits() > course2.getCredits()) {
            System.out.println(course1.getCode() + " is heavier than " + course2.getCode());
        } else if (course1.getCredits() < course2.getCredits()) {
            System.out.println(course2.getCode() + " is heavier than " + course1.getCode());
        } else {
            System.out.println("Courses have the same number of credits");
        }

        // Use isHeavyCourse() method
        System.out.println("Is " + course1.getCode() + " heavy? " + course1.isHeavyCourse());
        System.out.println("Is " + course2.getCode() + " heavy? " + course2.isHeavyCourse());

        // Compare professors by yearsOfExperience
        System.out.println("\n=== Compare professors by experience ===");
        if (prof1.getYearsOfExperience() > prof2.getYearsOfExperience()) {
            System.out.println(prof1.getName() + " is more experienced");
        } else if (prof1.getYearsOfExperience() < prof2.getYearsOfExperience()) {
            System.out.println(prof2.getName() + " is more experienced");
        } else {
            System.out.println("They have the same experience");
        }

        // Use isSenior() method
        System.out.println(prof1.getName() + " senior? " + prof1.isSenior());
        System.out.println(prof2.getName() + " senior? " + prof2.isSenior());

        // Compare universities by ranking (lower is better)
        System.out.println("\n=== Compare universities by ranking ===");
        if (uni1.getRanking() < uni2.getRanking()) {
            System.out.println(uni1.getName() + " has better ranking");
        } else if (uni1.getRanking() > uni2.getRanking()) {
            System.out.println(uni2.getName() + " has better ranking");
        } else {
            System.out.println("Universities have the same ranking");
        }

        // Use increaseStudents and isTopUniversity
        uni1.increaseStudents(200);
        System.out.println("\nAfter increasing students in " + uni1.getName() + ":");
        uni1.printInfo();
        System.out.println(uni1.getName() + " is top university? " + uni1.isTopUniversity());
        System.out.println(uni2.getName() + " is top university? " + uni2.isTopUniversity());
    }
}
