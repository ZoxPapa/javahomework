public class Main {
    public static void main(String[] args) {
        BaseOfEmployees db = new BaseOfEmployees();
        Employee employee1 = new Employee("123", "Masha", 12);
        Employee employee2 = new Employee("456", "Pasha", 2);
        Employee employee3 = new Employee("342", "Masha", 42);
        Employee employee4 = new Employee("124", "Dima", 8);
        Employee employee5 = new Employee("876", "Kolya", 1);
        db.addEmployeeToBase(employee1, employee2, employee3, employee4, employee5);

//        System.out.println(db.findByExperience(3));

//        System.out.println(db.findById(4));

//        System.out.println(db.findByName("Dima"));
    }
}