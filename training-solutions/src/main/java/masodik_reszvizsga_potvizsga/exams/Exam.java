package masodik_reszvizsga_potvizsga.exams;

public abstract class Exam {
    private long studentId;
    private String topic;
    protected int maxPoints;
    private ExamResult examResult;

    protected Exam(long studentId, String topic, int maxPoints) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = maxPoints;
    }

    protected Exam(long studentId, String topic) {
        this.studentId = studentId;
        this.topic = topic;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getTopic() {
        return topic;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    abstract void calculateExamResult(int actualPoints);
}
