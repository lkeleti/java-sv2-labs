package inheritancemethods.cars;

public class Jeep extends Car{
    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        if (calculateRefillAmount() >= fuel) {
            double emptyExtra = extraCapacity - extraFuel;
            if (fuel > emptyExtra) {
                double remainingFuel = fuel - emptyExtra;
                super.modifyFuelAmount(remainingFuel);
                extraFuel = extraCapacity;
            }
            else {
                extraFuel += fuel;
            }
        }
    }

    public void drive(int km) {
        double needFuel = km /100 * getFuelRate();
        if (needFuel > (extraFuel + getFuel())) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        else {
            if (needFuel < extraFuel) {
                extraFuel -= needFuel;
            }
            else {
                double needNormalFuel = needFuel - extraFuel;
                extraFuel = 0;
                setFuel(getFuel() - needNormalFuel);
            }
        }
    }

    @Override
    public double calculateRefillAmount() {
        return super.calculateRefillAmount() + extraCapacity - extraFuel;
    }

}
