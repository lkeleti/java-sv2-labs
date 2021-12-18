package masodik_reszvizsga_potvizsga.exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {
    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoint) {
        exam.calculateExamResult(actualPoint);
        exams.add(exam);
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int countPassedExams() {
        int counter = 0;
        for (Exam e : exams) {
            if (e.getExamResult() != ExamResult.NOT_PASSED) {
                counter++;
            }
        }
        return counter;
    }

    public List<Exam> findById(long studentId) {
        List<Exam> result = new ArrayList<>();
        for (Exam e : exams) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public List<String> findTopicByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        for (Exam e : exams) {
            String actualTopic = e.getTopic();
            if (actualTopic.startsWith(prefix) && notInTheList(result, actualTopic)) {
                result.add(actualTopic);
            }
        }
        return result;
    }

    private boolean notInTheList(List<String> topics, String actualTopic) {
        for (String topic: topics) {
            if (topic.equals(actualTopic)) {
                return false;
            }
        }
        return true;
    }
}
