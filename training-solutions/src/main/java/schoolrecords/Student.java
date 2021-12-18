package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (marks == null || marks.isEmpty()) {
            return name + " marks: ";
        } else {
            for (Mark mark : marks) {
                sb.append(mark.getSubject().getSubjectName());
                sb.append(": ");
                sb.append(mark);
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            return name + " marks: " + sb.toString();
        }
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    } // érdemjegy rögzítése

    public double calculateAverage() {
        double average = 0.0;
        for (Mark mark : marks) {
            average += mark.getMarkType().getMarkValue();
        }
        return Math.round(average * 100 / marks.size()) / 100.0;
    }// teljes átlag számolása

    public double calculateSubjectAverage(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Subject must not be null!");
        }
        double average = 0.0;
        int counter = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                average += mark.getMarkType().getMarkValue();
                counter++;
            }
        }

        if (counter == 0) {
            return 0.0;
        }

        return Math.round(average * 100 / counter) / 100.0;
    }// tantárgyhoz tartozó átlag számítása

    private boolean isEmpty(String str) {
        return (str == null || str.isEmpty());
    }
}
