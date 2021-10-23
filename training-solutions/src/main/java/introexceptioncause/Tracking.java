package introexceptioncause;

public class Tracking {
    public static void main(String[] args) {
        TrackPoints trackPoints = new TrackPoints();
        trackPoints.readCords("tracking.csv");
        trackPoints.writeLevelDifferences();
    }
}
