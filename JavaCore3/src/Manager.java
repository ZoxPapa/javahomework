import java.util.List;

public class Manager extends Employee{
    public Manager(String name, String jobTitle, int salary, int age) {
        super(name, jobTitle, salary, age);
    }
    static void increaseSalary (List<Employee> empList, int money){
        for(Employee employee: empList){
            if (employee.getAge() > 42 && !(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + money);
            }
        }
    }
}
