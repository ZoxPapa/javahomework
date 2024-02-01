package group;

import student.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudentsGroup implements Iterable<Student> {
    public List<Student> studentList;

    public StudentsGroup(Student ... k) {
        this.studentList = new ArrayList<>();
        Collections.addAll(studentList, k);
    }
    @Override
    public String toString() {
        String result = "Group ";
        for(Student student: studentList){
            result+= student+" ";
        }
        return result;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentsGroupIterator(this.studentList);
    }
}
