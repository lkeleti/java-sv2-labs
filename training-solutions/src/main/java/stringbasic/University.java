package stringbasic;

import java.util.ArrayList;
import java.util.List;

public class University {
    List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean areEqual(Student student, Student anotherStudent) {
        return student.getNeptunCode().equals(anotherStudent.getNeptunCode()) &&
                student.getEducationalId().equals(anotherStudent.getEducationalId());
    }
}
