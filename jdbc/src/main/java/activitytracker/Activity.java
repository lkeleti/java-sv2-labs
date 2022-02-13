package activitytracker;

import java.time.LocalDateTime;

public class Activity {
    private long id;
    private LocalDateTime startTime;
    private String desc;
    private Type type;

    public Activity(long id, LocalDateTime startTime, String desc, Type type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public Type getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }
}
