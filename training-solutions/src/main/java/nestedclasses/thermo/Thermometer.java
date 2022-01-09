package nestedclasses.thermo;

public class Thermometer {
    private String room;
    private int temperature;
    private ThermometerObserver thermometerObserver;

    public Thermometer(String room, int temperature) {
        this.room = room;
        this.temperature = temperature;
    }

    public String getRoom() {
        return room;
    }

    public int getTemperature() {
        return temperature;
    }

    public ThermometerObserver getThermometerObserver() {
        return thermometerObserver;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        onTemperatureChanged();
    }

    public void  onTemperatureChanged() {
        thermometerObserver.handleTemperatureChange(temperature, room);
    }

    public void setThermometerObserver(ThermometerObserver thermometerObserver) {
        this.thermometerObserver = thermometerObserver;
        onTemperatureChanged();
    }
}
