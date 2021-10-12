package looptypesmodify;

import java.util.ArrayList;
import java.util.List;

public class LanguageSchool {
    public static void removeInactive(List<Student> students) {
        List<Student> studentsToRemove = new ArrayList<>();
        for (Student student: students) {
            if (!student.isActive()) {
                studentsToRemove.add(student);
            }
        }
        students.removeAll(studentsToRemove);
    }
    public static void main(String[] args) {
        List<Student> students =new  ArrayList<>();
        students.add(new Student("Jack"));
        students.add(new Student("John"));
        students.add(new Student("Jane"));

        System.out.println("Jelenleg " + students.size() + " fő a csoport létszáma");
        removeInactive(students);
        students.get(1).setActive(false);
        removeInactive(students);
        System.out.println("Jelenleg " + students.size() + " fő a csoport létszáma");
    }
}
