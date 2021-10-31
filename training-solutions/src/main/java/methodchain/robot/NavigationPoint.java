package methodchain.robot;

public class NavigationPoint {
    private int distance;
    private int azimut;

    public NavigationPoint(int distance, int angle) {
        this.distance = distance;
        this.azimut = angle;
    }

    public int getDistance() {
        return distance;
    }

    public int getAngle() {
        return azimut;
    }

    @Override
    public String toString() {
        return "distance: " + distance +
                " azimut: " + azimut;
    }
}
