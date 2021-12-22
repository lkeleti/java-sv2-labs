package exceptionclass.course;

public class SimpleTime {
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalideTimeException("Time is null");
        }

        if (time.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            throw new InvalideTimeException("Time is not hh:mm");
        }
    }

    private boolean checkHour(int hour) {
        return false;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        String h = "0" + hour;
        String m = "0" + minute;
        return h.substring(h.length()-2,h.length()) + ":" + m.substring(m.length()-2,m.length()) +
                '}';
    }
}
