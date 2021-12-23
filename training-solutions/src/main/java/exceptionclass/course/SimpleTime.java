package exceptionclass.course;

public class SimpleTime {
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        checkHour(hour);
        checkMinute(minute);
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null");
        }

        if (!time.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        hour = Integer.parseInt(time.substring(0,2));
        minute = Integer.parseInt(time.substring(3,5));
        checkHour(hour);
        checkMinute(minute);
    }

    private boolean checkHour(int hour) {
        if (hour <  0 || hour > 23 ){
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        return true;
    }

    private boolean checkMinute(int minute) {
        if (minute <  0 || minute > 59 ){
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        return true;
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
        return h.substring(h.length()-2,h.length()) + ":" + m.substring(m.length()-2,m.length());
    }
}
