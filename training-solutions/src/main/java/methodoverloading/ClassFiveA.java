package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ClassFiveA {
    List<String> students = new ArrayList<>();

    public ClassFiveA(List<String> students) {
        this.students = students;
    }

    public String getTodayReferringStudent(int number) {
        return students.get(number);
    }

    public String getTodayReferringStudent(Number number) {
        return students.get(number.getValue());
    }

    public String getTodayReferringStudent(String numberName) {
        return students.get(Number.valueOf(numberName).getValue());
    }
}
