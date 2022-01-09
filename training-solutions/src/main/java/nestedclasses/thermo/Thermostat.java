package nestedclasses.thermo;

import java.util.ArrayList;
import java.util.List;

public class Thermostat {
    private List<Thermometer> thermometers = new ArrayList<>();
    private List<String> roomsToHeat = new ArrayList<>();
    private int temperatureLimit = 23;

    public void addThermometer(Thermometer thermometer) {
        class Observer implements ThermometerObserver {

            private int temperature;

            private String room;

            @Override
            public void handleTemperatureChange(int temp, String room) {
                this.temperature = temp;
                this.room = room;
                changeRoomsToHeat(thermometer);
            }

            public int getTemperature() {
                return temperature;
            }

            public String getRoom() {
                return room;
            }
        }
        thermometer.setThermometerObserver(
                new Observer()
        );
        thermometers.add(thermometer);
    }

    private void changeRoomsToHeat(Thermometer thermometer) {
        if (thermometer.getTemperature()<temperatureLimit) {
            roomsToHeat.add(thermometer.getRoom());
        }
        else {
            roomsToHeat.remove(thermometer.getRoom());
        }
    }

    public List<Thermometer> getThermometers() {
        return new ArrayList<>(thermometers);
    }

    public List<String> getRoomsToHeat() {
        return new ArrayList<>(roomsToHeat);
    }

    public int getTemperatureLimit() {
        return temperatureLimit;
    }
}
