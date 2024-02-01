import group.StudentsGroup;
import group.StudentsGroupService;
import stream.Stream;
import stream.StreamService;
import student.Student;

import java.util.List;

public class Controller {
    private StudentsGroupService studentsGroupService;
    private StreamService streamService;

    public void removeStudentByName(Student student, StudentsGroup studentGroup){
        studentsGroupService = new StudentsGroupService(studentGroup);
        studentsGroupService.removeStudentByName(student, studentGroup);
    }

    public void sortStreamsByQtyOfGroups(List<Stream> streamList) {
        streamService = new StreamService(streamList);
        streamService.sortStreamsByQtyOfGroups();
    }
}
