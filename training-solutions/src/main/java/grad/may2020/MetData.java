package grad.may2020;

import java.time.LocalTime;

public class MetData {
    private String settlement;
    private LocalTime timeOfMeasurement;
    private String windDirection;
    private int windSpeed;
    private int degree;

    public MetData(String settlement, LocalTime timeOfMeasurement, String windDirection, int windSpeed, int degree) {
        this.settlement = settlement;
        this.timeOfMeasurement = timeOfMeasurement;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.degree = degree;
    }

    public String getSettlement() {
        return settlement;
    }

    public LocalTime getTimeOfMeasurement() {
        return timeOfMeasurement;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getDegree() {
        return degree;
    }
}
