package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> subjects = new ArrayList<>();

    public Tutor(String name, List<Subject> subjects) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Subject can't be empty!");
        }
        for (Subject s : subjects) {
            if (s.getSubjectName().equals(subject.getSubjectName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty(String str) {
        return (str == null || str.isEmpty());
    }
}
