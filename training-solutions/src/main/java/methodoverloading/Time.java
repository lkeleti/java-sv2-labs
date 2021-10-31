package methodoverloading;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = 0;

    }
    public Time(int hours) {
        this.hours = hours;
        this.minutes = 0;
        this.seconds = 0;
    }
    public Time(Time time) {
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time) {
        if (hours == time.getHours() &&
                minutes == time.getMinutes() &&
                seconds == time.getSeconds()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        if (this.hours == hours &&
                this.minutes == minutes &&
                this.seconds == seconds) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isEarlier(Time time) {
        int parameterTimeInSeconds =time.getSeconds() + time.getMinutes() * 60 + time.getHours() * 60 * 60;
        int defaultTimeInSeconds = seconds + minutes * 60 + hours * 60 * 60;
        return defaultTimeInSeconds < parameterTimeInSeconds;
    }
    public boolean isEarlier(int hours, int minutes, int seconds) {
        int parameterTimeInSeconds = seconds + minutes * 60 + hours * 60 * 60;
        int defaultTimeInSeconds = this.seconds + this.minutes * 60 + this.hours * 60 * 60;
        return defaultTimeInSeconds < parameterTimeInSeconds;
    }
}
