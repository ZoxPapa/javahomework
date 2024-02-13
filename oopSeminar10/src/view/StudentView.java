package view;

import model.Student;
import service.DataService;

public class StudentView {
    private DataService service = new DataService();
    public void sendToConsole(Student student){
        service.readUser(student);
    }
}
