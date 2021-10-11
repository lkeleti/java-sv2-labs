package looptypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudyGroup {
    public void printStudyGroups(List<String> students) {
        List<String> shortNames = new ArrayList<>();
        List<String> longNames = new ArrayList<>();

        for (String student: students) {
            if (student.length() > 10) {
                longNames.add(student);
            }
            else {
                shortNames.add(student);
            }
        }
        System.out.println("Rövid nevű csoport tagjai: " + shortNames);
        System.out.println("Hosszú nevű csoport tagjai: " + longNames);
    }

    public static void main(String[] args) {
        StudyGroup studyGroup = new StudyGroup();
        List<String> students = new ArrayList<>(Arrays.asList("Kis Pál", "Nagy Béla", "Kovács István",
                "Mészáros János"));
        studyGroup.printStudyGroups(students);
    }

}
