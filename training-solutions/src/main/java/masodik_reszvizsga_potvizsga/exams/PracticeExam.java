package masodik_reszvizsga_potvizsga.exams;

import java.util.List;

public class PracticeExam extends Exam{
    public PracticeExam(long studentId, String topic, List<Integer> pointsByExercises) {
        super(studentId, topic);
        int maxPoints = 0;
        for (int i: pointsByExercises) {
            maxPoints += i;
        }

        if ( maxPoints >= 10 && maxPoints <= 150) {
            super.maxPoints = maxPoints;
        }
        else {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + maxPoints);
        }
    }

    @Override
    void calculateExamResult(int actualPoints) {
        double percent = actualPoints*100.0/maxPoints;
        if (percent < 51) {
            setExamResult(ExamResult.NOT_PASSED);
        }
        else if (percent >= 51 && percent < 76) {
            setExamResult(ExamResult.OK);
        }
        else {
            setExamResult(ExamResult.PERFECT);
        }
    }
}
