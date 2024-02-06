import group.StudentsGroup;
import stream.Stream;
import student.Student;
import student.StudentController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        StudentController studentController = new StudentController();
        Student student1 = studentController.create("Max", 18);
        Student student2 = studentController.create("Bob", 22);
        Student student3 = studentController.create("Lisa", 20);
        //создание групп студентов
        StudentsGroup myGroup11 = new StudentsGroup(student1, student2, student3);
        studentController.sendToConsole(myGroup11.studentList);
        StudentsGroup myGroup21 = new StudentsGroup();
        StudentsGroup myGroup22 = new StudentsGroup();
        StudentsGroup myGroup31 = new StudentsGroup();
        StudentsGroup myGroup32 = new StudentsGroup();
        StudentsGroup myGroup33 = new StudentsGroup();
        //создание потоков с разным количеством групп
        Stream stream1 = new Stream(myGroup11);
        Stream stream2 = new Stream(myGroup21, myGroup22);
        Stream stream3 = new Stream(myGroup31, myGroup32, myGroup33);
        //создание списка потоков для передачи в сортировку
        //TODO: как можно реализовать сортировку без передачи списка?
        List<Stream> streamList = new ArrayList<>();
        streamList.add(stream3);streamList.add(stream1);streamList.add(stream2);
        //вывод списка потоков до и после сортировки
        System.out.println(streamList);
        controller.sortStreamsByQtyOfGroups(streamList);
        System.out.println(streamList);



    }
}