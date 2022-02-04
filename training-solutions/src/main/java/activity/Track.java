package activity;

import java.io.InputStream;
import java.util.*;

public class Track {
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public double getFullElevation() {
        double fullElevation = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            double actElev = trackPoints.get(i).getElevation();
            double befElev = trackPoints.get(i - 1).getElevation();
            if (actElev > befElev) {
                fullElevation += (actElev - befElev);
            }
        }
        return fullElevation;
    }

    public double getFullDecrease() {
        double fullDecrease = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            double actElev = trackPoints.get(i).getElevation();
            double befElev = trackPoints.get(i - 1).getElevation();
            if (actElev < befElev) {
                fullDecrease += (befElev - actElev);
            }
        }
        return fullDecrease;
    }

    public double getDistance() {
        double fullDistance = 0.0;
        for (int i = 1; i < trackPoints.size(); i++) {
            fullDistance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i - 1));
        }
        return fullDistance;
    }

    public Coordinate findMinimumCoordinate() {
        double minLong = trackPoints.stream()
                .mapToDouble(t -> t.getCoordinate().getLongitude())
                .min().orElseThrow(() -> new IllegalArgumentException("Tracking points is empty"));
        double minLat = trackPoints.stream()
                .mapToDouble(t -> t.getCoordinate().getLatitude())
                .min().orElseThrow(() -> new IllegalArgumentException("Tracking points is empty"));
        return new Coordinate(minLat, minLong);
    }

    public Coordinate findMaximumCoordinate() {
        double maxLong = trackPoints.stream()
                .mapToDouble(t -> t.getCoordinate().getLongitude())
                .max().orElseThrow(() -> new IllegalArgumentException("Tracking points is empty"));
        double maxLat = trackPoints.stream()
                .mapToDouble(t -> t.getCoordinate().getLatitude())
                .max().orElseThrow(() -> new IllegalArgumentException("Tracking points is empty"));
        return new Coordinate(maxLat, maxLong);
    }

    public void loadFromGpx(InputStream is) {
        Scanner scanner = new Scanner(is);
        Coordinate coordinate = null;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains("<trkpt")) {
                coordinate = getCoordinateFromLine(line);
            }
            if (line.contains("<ele")) {
                trackPoints.add(new TrackPoint(coordinate, getElevationFromLine(line)));
            }
        }
    }

    private Coordinate getCoordinateFromLine(String line) {
        int startLat = line.indexOf("lat=") + 5;
        int endLat = line.indexOf("lon=") - 2;
        int endLon = line.indexOf(">") - 1;
        return new Coordinate(
                Double.parseDouble(line.substring(startLat, endLat)),
                Double.parseDouble(line.substring(endLat + 7, endLon))
        );
    }

    private double getElevationFromLine(String line) {
        int start = line.indexOf("<ele>") + 5;
        int end = line.indexOf("</ele>");
        return Double.parseDouble(line.substring(start, end));
    }

    public double getRectangleArea() {
        return 0.0;
    }
}
