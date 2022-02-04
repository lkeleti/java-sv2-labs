package activity;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    private static final double MIN_LATITUDE = -90.0;
    private static final double MAX_LATITUDE = 90.0;
    private static final double MIN_LONGITUDE = -180.0;
    private static final double MAX_LONGITUDE = 180.0;


    public Coordinate(double latitude, double longitude) {
        validateLatitude(latitude);
        validateLongitude(longitude);

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private boolean validateLatitude(double latitude) {
        if (latitude >= MIN_LATITUDE && latitude<= MAX_LATITUDE) {
            return true;
        }
        throw new IllegalArgumentException("Invalid latitude");
    }

    private boolean validateLongitude(double longitude) {
        if (longitude >= MIN_LONGITUDE && longitude<= MAX_LONGITUDE) {
            return true;
        }
        throw new IllegalArgumentException("Invalid longitude");
    }
}
