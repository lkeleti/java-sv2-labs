package sorting;

import java.time.LocalDateTime;

public class Patient {
    private String name;
    private String taj;
    private LocalDateTime dateTime;

    public Patient(String name, String taj, LocalDateTime dateTime) {
        this.name = name;
        this.taj = taj;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public String getTaj() {
        return taj;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
