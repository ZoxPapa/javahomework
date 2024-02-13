import controller.Controller;
import model.Student;
import model.User;
import service.DataService;
import view.StudentView;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStudent("Joel", "Embiid", 1024);
        controller.createStudent("LeBron", "James", 1021);
        controller.createStudent("Paul", "George", 1021);
        controller.createStudent("Chris", "Paul", 1021);
        controller.createTeacher("Karim", "Abdul-Jabbar", 1021);
        controller.createTeacher("Michael", "Jordan", 1021);
        controller.createStudyGroup(2);

    }
}