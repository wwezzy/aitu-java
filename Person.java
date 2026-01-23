public abstract class Person {
    private String name;
    private String surname;
    private int id;
    public Person (String name, String surname,  int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getId() {
        return id;
    }
    public abstract String getRole();
   @Override
    public String toString() {
       return "Name:" + name + " " + "Surname:" + surname + " " + "ID:" + id;
   }
   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
   }
}