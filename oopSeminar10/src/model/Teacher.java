package model;

public class Teacher extends User{
    public Teacher(String firstName, String secondName, int birthYear, int teacherId) {
        super(firstName, secondName, birthYear);
        this.teacherId = teacherId;
    }

    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
