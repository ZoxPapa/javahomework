package controller;

import model.Student;
import model.Teacher;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;

import java.util.List;

public class Controller {
    private DataService dataService = new DataService();
    private StudentView studentView = new StudentView();
    private StudyGroupService groupService = new StudyGroupService();
    public void createStudent(String firstName, String secondName, int birthYear){
        Student student = dataService.createStudent(firstName, secondName, birthYear);
        studentView.sendToConsole(student);
    }
    public void createTeacher(String firstName, String secondName, int birthYear) {
        Teacher teacher = dataService.createTeacher(firstName, secondName, birthYear);
    }
    public void printAllStudents(){
        for(Student student : dataService.getAllStudents()){
            studentView.sendToConsole(student);
        }
    }

    public void createStudyGroup(int teacherId){
        Teacher teacher = dataService.getTeacherById(teacherId);
        List<Student> students = dataService.getAllStudents();
        groupService.createStudyGroup(teacher, students);
        System.out.println("Group is created. \n Teacher: "+ teacher.getFirstName()+
                " "+ teacher.getSecondName() + "\n Students: ");
        for(Student student: students){
            studentView.sendToConsole(student);
        }

    }
}
