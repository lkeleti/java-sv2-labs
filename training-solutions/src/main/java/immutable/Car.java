package immutable;

import java.time.LocalDate;

public class Car {

    private final  String brandOfCar;
    private final String typeOfCar;
    private final int manufacturingYear;

    public Car(String brandOfCar, String typeOfCar, int manufacturingYear) {
        int defYear = LocalDate.now().getYear();

        if (brandOfCar == null || brandOfCar.trim().length() < 1 || manufacturingYear > defYear){
            throw new IllegalArgumentException("");
        }

        this.brandOfCar = brandOfCar;
        this.typeOfCar = typeOfCar;
        this.manufacturingYear = manufacturingYear;
    }

    public String getBrandOfCar() {
        return brandOfCar;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }
}
