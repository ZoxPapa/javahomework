package student;

import user.User;
import user.UserController;

import java.util.List;

public class StudentController implements UserController<Student> {
    StudentView studentView = new StudentView();

    @Override
    public <T extends User> T create(String name, int age) {
        return (T) new Student(name, age);
    }

    @Override
    public <T extends User> void sendToConsole(List<T> usersList) {
        studentView.sendOnConsole((List<Student>) usersList);
    }
}
