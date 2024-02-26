import java.util.ArrayList;
import java.util.List;

public class BaseOfEmployees {
    List<Employee> employeeList = new ArrayList<>();

    public void addEmployeeToBase(Employee ... employee){
        this.employeeList.addAll(List.of(employee));
    }
    public List<Employee> findByExperience(int experience){
        List<Employee> result = new ArrayList<>();
        for(Employee employee: employeeList){
            if(employee.getExperience()>=experience) result.add(employee);
        }
        return result;
    }
    public List<Employee> findByName(String name){
        List<Employee> result = new ArrayList<>();
        for(Employee employee: employeeList){
            if(employee.getName().equalsIgnoreCase(name)) result.add(employee);
        }
        return result;
    }
    public Employee findById (int id){
        for(Employee employee: employeeList){
            if (employee.getId()==id) return employee;
        }
        return null;
    }
}
