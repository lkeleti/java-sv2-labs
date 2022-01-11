package collectionsclass;

import java.util.Objects;

public class ExamResult {
    private String name;
    private int point;

    public ExamResult(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamResult that = (ExamResult) o;
        return point == that.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
