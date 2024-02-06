package teacher;

import user.User;
import user.UserController;

import java.util.List;
import java.util.Scanner;

public class TeacherController implements UserController<Teacher> {
    TeacherView teacherView = new TeacherView();

    @Override
    public <T extends User> T create(String name, int age) {
        Teacher teacher = new Teacher(name, age);
        return (T)teacher;
    }

    @Override
    public <T extends User> void sendToConsole(List<T> usersList) {
        teacherView.sendOnConsole((List<Teacher>) usersList);
    }
    public void sendToConsole(Teacher teacher){
        teacherView.sendOnConsole(teacher);
    }
    public void editTeacher(Teacher teacher){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("What do you want to change?");
            System.out.println("Please input NAME or AGE: ");
            String answer = sc.nextLine();
            if(answer.equalsIgnoreCase("NAME")){
                System.out.println("Input name: ");
                teacher.setName(sc.nextLine());
                flag = false;
            } else if (answer.equalsIgnoreCase("AGE")) {
                System.out.println("Input age: ");
                teacher.setAge(sc.nextInt());
                flag = false;
            }
        }
    }
}
