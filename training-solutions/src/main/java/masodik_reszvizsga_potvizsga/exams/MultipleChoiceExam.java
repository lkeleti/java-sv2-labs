package masodik_reszvizsga_potvizsga.exams;

public class MultipleChoiceExam extends Exam{

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
        maxPoints = 100;
    }

    @Override
    void calculateExamResult(int actualPoints) {
        if (actualPoints < 0 || actualPoints > maxPoints) {
            throw new IllegalArgumentException("Wrong point");
        }

        if ((actualPoints*100.0)/maxPoints > 51) {
            setExamResult(ExamResult.PASSED);
        }
        else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
