package teacher;

import user.UserView;

import java.util.List;

public class TeacherView implements UserView<Teacher> {

    @Override
    public void sendOnConsole(List<Teacher> usersList) {
        for(Teacher teacher: usersList){
            System.out.println("Teacher: " + teacher.getName() + " Age: " + teacher.getAge());
        }
    }
    public void sendOnConsole(Teacher teacher){
        System.out.println("Teacher: " + teacher.getName() + " Age: " + teacher.getAge());
    }
}
