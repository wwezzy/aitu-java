public class Professor extends Person {
    private String subject;
    public Professor(String name, String surname,  int id, String subject) {
        super(name, surname, id);
        this.subject = subject;

    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getRole () {
        return "Professor";
    }
    @Override
    public String toString() {
        return super.toString() + "\nSubject:" + subject ;
    }
}
