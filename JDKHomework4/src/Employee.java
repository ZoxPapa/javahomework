public class Employee {
    static int counter = 0;
    int id = 1 + counter;
    String phone;
    String name;
    int experience;

    public Employee(String phone, String name, int experience) {
        this.phone = phone;
        this.name = name;
        this.experience = experience;
        counter++;
    }

    public int getId() {
        return this.id;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return id+ " " +name;
    }
}
