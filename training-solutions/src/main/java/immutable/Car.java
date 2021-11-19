package immutable;

import java.time.LocalDate;

public class Car {

    private final  String brand;
    private final String model;
    private final int yearOfProduction;

    public Car(String brand, String model, int yearOfProduction) {
        int defYear = LocalDate.now().getYear();

        if (brand == null || brand.trim().length() < 1){
            throw new IllegalArgumentException("Brand name cannot be empty!");
        }

        if (yearOfProduction > defYear) {
            throw new IllegalArgumentException("Year of production cannot be in the future!");
        }
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }
}
