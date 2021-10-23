package introexceptioncause;

public class Tracking {
    public static void main(String[] args) {
        TrackPoints trackPoints = new TrackPoints();
        trackPoints.readCords("src/main/resources/tracking.csv");
        trackPoints.writeLevelDifferences();
    }
}
