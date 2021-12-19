package virtualmethod.vehicle;

import java.util.Objects;

public class FerryBoat extends Vehicle {
    public static final int MAX_CARRY_WEIGHT = 2000;
    private Car car;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    @Override
    public int getGrossLoad() {
        if (car == null) {
            return super.getGrossLoad();
        } else {
            return super.getGrossLoad() + car.getVehicleWeight() + PERSON_AVERAGE_WEIGHT;
        }
    }

    public boolean canCarry(Car car) {
        return car.getVehicleWeight() < MAX_CARRY_WEIGHT;
    }

    public boolean load(Car car) {
        if (canCarry(car)) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (car.getClass() == Car.class) {
            return "FerryBoat{" +
                    "car=" + car.toString() +
                    '}';
        } else {
            return "FerryBoat{" +
                    "car=" + car.toString() +
                    '}';
        }
    }
}
