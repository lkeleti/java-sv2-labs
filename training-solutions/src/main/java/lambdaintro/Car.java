package lambdaintro;

public class Car {
    private String brand;
    private String typeOfCar;
    private int price;
    private double length;

    public Car(String brand, String typeOfCar, int price, double length) {
        this.brand = brand;
        this.typeOfCar = typeOfCar;
        this.price = price;
        this.length = length;
    }

    public String getBrand() {
        return brand;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public int getPrice() {
        return price;
    }

    public double getLength() {
        return length;
    }
}
