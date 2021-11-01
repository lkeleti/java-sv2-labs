package inheritanceconstructor.cars;

public class Car {
    private final double fuelRate;
    private double fuel;
    private final double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        this.fuelRate = fuelRate;
        this.tankCapacity = tankCapacity;
        modifyFuelAmount(fuel);
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        if (this.fuel + fuel <= tankCapacity) {
            this.fuel += fuel;
        }
        else{
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
    }

    public void drive(int km) {
        // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
        if (isEnoughFuel(km)) {
            fuel -= fuelRate * km / 100;
        }
    }

    public double calculateRefillAmount() {
        //kiszámolja, mennyit lehet tankolni
        return tankCapacity-fuel;
    }

    private boolean isEnoughFuel(int km) {
        double neededFuel = fuelRate * km / 100;
        if (fuel > neededFuel) {
            return true;
        }
        else {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }
}
