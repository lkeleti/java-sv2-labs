package schoolrecords;

public enum MarkType {
    A(5, "excellent"), B(4, "very good"), C(3, "improvement needed"), D(2, "close fail"), F(1, "fail");

    private int markValue;
    private String description;

    MarkType(int markValue, String description) {
        this.markValue = markValue;
        this.description = description;
    }

    public int getMarkValue() {
        return markValue;
    }

    public String getDescription() {
        return description;
    }
}
