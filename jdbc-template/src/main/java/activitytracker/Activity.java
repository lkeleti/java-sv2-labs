package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {
    private long id;
    private java.time.LocalDateTime startTime;
    private String description;
    private Type type;
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Activity(long id, LocalDateTime startTime, String description, Type type) {
        this.id = id;
        this.startTime = startTime;
        this.description = description;
        this.type = type;
    }

    public Activity(long id, LocalDateTime startTime, String description, Type type, List<TrackPoint> trackPoints) {
        this.id = id;
        this.startTime = startTime;
        this.description = description;
        this.type = type;
        this.trackPoints = trackPoints;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
