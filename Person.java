import java.util.Objects;

public abstract class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Требование: Override toString
    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email;
    }

    // Требование: Override equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email); // Считаем уникальным по email
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}