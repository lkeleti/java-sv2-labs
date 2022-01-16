package lambdaintro;

public class Flat {
    private String address;
    private int area;
    private int price;

    public Flat(String address, int area, int price) {
        this.address = address;
        this.area = area;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }
}
