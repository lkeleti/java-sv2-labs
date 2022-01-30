package grad.may2012;

public class DistanceData {
    private int numberOfDay;
    private int numberOfJob;
    private int distance;

    public DistanceData(int numberOfDay, int numberOfJob, int distance) {
        this.numberOfDay = numberOfDay;
        this.numberOfJob = numberOfJob;
        this.distance = distance;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public int getNumberOfJob() {
        return numberOfJob;
    }

    public int getDistance() {
        return distance;
    }
}
