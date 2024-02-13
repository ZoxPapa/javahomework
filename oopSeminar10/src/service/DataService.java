package service;

import model.Student;
import model.Teacher;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<User> userList = new ArrayList<>();

    public Student createStudent(String firstName, String secondName, int birthYear){
        Student student = new Student(firstName, secondName, birthYear, getId(true));
        userList.add(student);
        return student;
    }
    public Teacher createTeacher(String firstName, String secondName, int birthYear){
        Teacher teacher = new Teacher(firstName, secondName, birthYear, getId(false));
        userList.add(teacher);
        return teacher;
    }
    private int getId(boolean studentOrTeacher){
        int teacherId = 0;
        int studentId = 0;
        for (User user: userList){
            if (user instanceof Student) {
                studentId=((Student) user).getStudentId();
            } else if (user instanceof Teacher){
                teacherId=((Teacher) user).getTeacherId();
            }
        }
        return studentOrTeacher ? studentId+1 : teacherId+1;
    }

    public void readUser(User user){
        if(user instanceof Student){
            System.out.println("ID: " + ((Student) user).getStudentId() +
                user.getFirstName()
                + user.getSecondName() +user.getBirthYear());
        }else if(user instanceof Teacher){
            System.out.println("ID: " + ((Teacher) user).getTeacherId() +
                    user.getFirstName()
                    + user.getSecondName() +user.getBirthYear());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for(User user: userList){
            if(user instanceof Student){
                students.add((Student) user);
            }
        }
        return students;
    }
    public Teacher getTeacherById(int teacherId){
        for(User user: userList){
            if(user instanceof Teacher && ((Teacher) user).getTeacherId() == teacherId){
                return (Teacher) user;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
