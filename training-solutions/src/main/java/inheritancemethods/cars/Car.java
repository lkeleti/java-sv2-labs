package inheritancemethods.cars;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void modifyFuelAmount(double fuel) {
        if (calculateRefillAmount() >= fuel) {
            this.fuel += fuel;
        } else {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }

    public void drive(int km) {
        double needFuel = km / 100 * fuelRate;
        if (needFuel <= fuel) {
            fuel -= needFuel;
        } else {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }
}
