package collectionsset;

import java.util.*;

public class PhysicalEducation {
    public Set<Integer> getOrderInLessons(List<Student> students) {
        Set<Integer> heights = new TreeSet<>();
        for (Student student: students) {
            heights.add(student.getHeight());
        }
        return heights;
    }

    public static void main(String[] args) {
        PhysicalEducation physicalEducation = new PhysicalEducation();
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("john Doue", 175),
                        new Student("Jane Doe",160),
                        new Student("Jack Doe",180)
                )
        );
        System.out.println(physicalEducation.getOrderInLessons(students));
    }
}
