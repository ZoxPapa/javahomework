package group;

import student.Student;

import java.util.Iterator;
import java.util.List;

public class StudentsGroupIterator implements Iterator<Student> {
    private int counter;
    private final List<Student> studentList;

    public StudentsGroupIterator(List<Student> studentList) {
        this.counter=0;
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return counter<studentList.size();
    }

    @Override
    public Student next() {
        if (!hasNext()){
            return null;
        }
        counter++;
        return studentList.get(counter-1);
    }

    @Override
    public void remove() {
        studentList.remove(counter-1);
    }
}
