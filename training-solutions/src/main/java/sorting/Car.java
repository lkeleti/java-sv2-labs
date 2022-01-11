package sorting;

public class Car {
    private String brand;
    private int YearOfConstruction;
    private int price;

    public Car(String brand, int yearOfConstruction, int price) {
        this.brand = brand;
        YearOfConstruction = yearOfConstruction;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getYearOfConstruction() {
        return YearOfConstruction;
    }

    public int getPrice() {
        return price;
    }
}
