package meetingrooms;

public class MeetingRoom {
    private String name;
    private int length;
    private int width;

    private boolean checkName (String name) {
        return (name != null && name.trim().length() > 0);
    }

    private boolean checkGreaterThanZero(int value) {
        return value > 0;
    }

    public MeetingRoom(String name, int length, int width) {
        if (checkName(name)) {
            this.name = name;
        }

        if (checkGreaterThanZero(length)) {
            this.length = length;
        }

        if (checkGreaterThanZero(width)) {
            this.width = width;
        }
    }

    public int getArea() {
        return length * width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (checkName(name)) {
            this.name = name;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (checkGreaterThanZero(length)) {
            this.length = length;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (checkGreaterThanZero(width)) {
            this.width = width;
        }
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
