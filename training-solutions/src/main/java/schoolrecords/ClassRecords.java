package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random random;
    List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random random) {
        this.className = className;
        this.random = random;
    }

    public String getClassName() {
        return className;
    }

    public Random getRandom() {
        return random;
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Student can't be empty!");
        }
        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Student can't be empty!");
        }
        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                students.remove(s);
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }

        double average = 0.0;
        for (Student student : students) {
            average += student.calculateAverage();
        }
        if (average == 0.0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round(average * 100 / students.size()) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double average = 0.0;
        int counter = 0;
        for (Student student : students) {
            double actualAverage = student.calculateSubjectAverage(subject);
            if (actualAverage != 0.0) {
                average += actualAverage;
                counter++;
            }
        }

        if (counter == 0) {
            throw new ArithmeticException("There is no marks to this subject!");
        }

        return Math.round(average * 100 / counter) / 100.0;
    }
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    } // név szerint megkeres egy diákot az osztályban

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }

        return students.get(random.nextInt(students.size()));
    } //felelethez a listából random módon kiválaszt egy diákot

    public List<StudyResultByName> listStudyResults() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        List<StudyResultByName> result = new ArrayList<>();
        for (Student student : students) {
            result.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return result;
    } //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza

    public String listStudentNames() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getName());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    } //kilistázza a diákok neveit, vesszővel elválasztva


    private boolean isEmpty(String str) {
        return (str == null || str.isEmpty());
    }
}
