package meetingrooms;

public class MeetingRoom {
    private String name;
    private int length;
    private int width;

    public MeetingRoom(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tárgyaló neve:\t");
        sb.append(getName());
        sb.append(System.lineSeparator());
        sb.append("Szélessége:\t");
        sb.append(getWidth());
        sb.append(System.lineSeparator());
        sb.append("Hosszúsága:\t");
        sb.append(getLength());
        sb.append(System.lineSeparator());
        sb.append("Területe:\t");
        sb.append(getArea());

        return sb.toString();
    }
}
