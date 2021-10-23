package introexceptioncause;

public class GpsInfo {
    private double latitude;
    private double longitude;
    private int height;

    public GpsInfo(double latitude, double longitude, int height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getHeight() {
        return height;
    }
}
