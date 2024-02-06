package student;

import user.UserView;

import java.util.List;

public class StudentView implements UserView <student.Student> {


    @Override
    public void sendOnConsole(List<Student> usersList) {
        for(Student student: usersList) System.out.println(student);
    }
}
