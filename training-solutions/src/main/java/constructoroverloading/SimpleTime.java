package constructoroverloading;

public class SimpleTime {
    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this(hours, 0);
    }

    public SimpleTime(SimpleTime time) {
        hours = time.getHours();
        minutes = time.getMinutes();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time) {
        return (hours-time.getHours()) *60 + minutes-time.getMinutes();
    }

    private String right(String text, int value) {
        return text.substring(text.length()-value,text.length());
    }
    @Override
    public String toString() {
        return right("0" + hours,2) + ":" + right("0" + minutes,2);
    }
}
