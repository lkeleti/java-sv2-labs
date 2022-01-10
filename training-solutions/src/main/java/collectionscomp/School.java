package collectionscomp;

import java.text.Collator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class School {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>(new StudentComparator());
        students.add(new Student("John Doe",180));
        students.add(new Student("Jack Doe",175));
        students.add(new Student("Jane Doe",160));
        System.out.println(students);

        Map<String, Integer> studentsMap = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));
        studentsMap.put("John Doe",180);
        studentsMap.put("Jack Doe",175);
        studentsMap.put("Jane Doe",160);

        System.out.println(studentsMap);
    }
}
