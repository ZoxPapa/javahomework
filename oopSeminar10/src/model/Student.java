package model;

public class Student extends User{
    public Student(String firstName, String secondName, int birthYear, int studentId) {
        super(firstName, secondName, birthYear);
        this.studentId = studentId;
    }

    int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
