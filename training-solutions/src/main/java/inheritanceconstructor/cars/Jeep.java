package inheritanceconstructor.cars;

public class Jeep extends Car{
    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel <= extraCapacity) {
            this.extraCapacity = extraCapacity;
            this.extraFuel = extraFuel;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    @Override
    public void modifyFuelAmount(double fuel) {
        double copyOfFuel = fuel;
        if (extraCapacity - extraFuel > 0) {
            copyOfFuel = (copyOfFuel - (extraCapacity - extraFuel));
            extraFuel = extraCapacity;
        }
        super.modifyFuelAmount(copyOfFuel);
    }

    @Override
    public void drive(int km) {
        // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!
        if (isEnoughExtendedFuel(km)) {
            double neededFuel = super.getFuelRate() * km / 100;
            if (extraFuel >= neededFuel) {
                extraFuel -= neededFuel;
            }
            else {
                neededFuel -= extraFuel;
                extraFuel = 0;
                super.modifyFuelAmount(-1*neededFuel);
            }
        }
    }

    @Override
    public double calculateRefillAmount() {
        //kiszámolja, mennyit lehet tankolni
        return (extraCapacity-extraFuel) + super.calculateRefillAmount();
    }

    private boolean isEnoughExtendedFuel(int km) {
        double neededFuel = super.getFuelRate() * km / 100;
        if ((super.getFuel()+extraFuel) > neededFuel) {
            return true;
        }
        else {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    }
}
