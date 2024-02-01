package group;

import student.Student;

import java.util.Iterator;

public class StudentsGroupService {
    private StudentsGroup studentsGroup;

    public StudentsGroupService(StudentsGroup studentsGroup) {
        this.studentsGroup = studentsGroup;
    }

    public void removeStudentByName(Student removableStudent, StudentsGroup studentGroup){
        Iterator<Student> iterator = studentsGroup.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getName().equals(removableStudent.getName())){
                iterator.remove();
            }
        }
    }
}
