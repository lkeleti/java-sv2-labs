package introconstructors;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private int duration;
    // fordításkor automatikusan létrejön egy üres konstruktor, feltéve, hogy nem készítünk magunk egyet


    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }
    /*Így már a lefordított fájlban olyan konstruktor szerepel
    melyben mind a két attributumnak értéket ad a meghívásnál átadott paramétereknek megfelelően
     */

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void start() {
        startDateTime = LocalDateTime.now();
    }
}
