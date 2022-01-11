package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {
    private List<ExamResult> examResults;

    public Exam(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public List<String> getNamesOfSucceededPeople(int places) {
        List<ExamResult> tmpExamResults = new ArrayList<>(examResults);
        Collections.sort(tmpExamResults, (o1, o2) -> o2.getPoint() - o1.getPoint());
        List<String> names = new ArrayList<>();
        for (int i = 0; i< places; i++ ) {
            names.add(tmpExamResults.get(i).getName());
        }
        return names;
    }
}
