import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Manager worker0 = new Manager("Max", "Manager", 150000, 45);
        Employee worker1 = new Employee("John", "Developer", 100000, 25);
        Employee worker2 = new Employee("Bob", "Tester", 75000, 30);
        Employee worker3 = new Employee("Lisa", "Product owner", 100000, 43);
        List<Employee> workersList = new ArrayList<>();
        workersList.add(worker0);workersList.add(worker1);
        workersList.add(worker2);workersList.add(worker3);

//        System.out.println(workersList);
//        worker0.increaseSalary(workersList, 999);
//        System.out.println(workersList);
//
//        Collections.sort(workersList);
//        System.out.println(workersList);



    }
}