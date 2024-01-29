import java.util.List;

public class Employee implements Comparable<Employee>{
    public Employee(String name, String jobTitle, int salary, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", salary=" + salary +
                ", age" + age +"\n";
    }

    private int age;
    private String name;
    private String surname;
    private String jobTitle;
    private String phoneNumber;
    private int salary;


    public String getJobTitle() {
        return jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        if(this.getSalary()==o.getSalary()) return 0;
        return this.getSalary()>o.getSalary() ? 1 : -1;
    }


}
