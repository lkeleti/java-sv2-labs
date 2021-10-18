package looptypesmodify;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private boolean active;

    public Student(String name) {
        this.name = name;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void removeInactive(List<Student> students) {
        List<Student> studentsToRemove = new ArrayList<>();
        for (Student student: students) {
            if (!student.isActive()) {
                studentsToRemove.add(student);
            }
        }
        students.removeAll(studentsToRemove);
    }
}
