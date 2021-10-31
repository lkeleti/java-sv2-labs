package methodchain.robot;


import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance = 0;
    private int azimut = 0;

    private List<NavigationPoint> navigationList = new ArrayList<>();

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot go(int meter) {
        distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        azimut += angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationList.add(new NavigationPoint(distance,azimut));
        return this;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationList;
    }
}
