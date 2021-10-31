package methodstructure;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int percent) {
        price = (int) (price * (1+(percent/100.00)));
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double currentPriceCapacity = (double)price/capacity;
        double otherPriceCapacity = (double)pendrive.getPrice()/pendrive.getCapacity();

        if (currentPriceCapacity < otherPriceCapacity) {
            return -1;
        }
        else {
            if (currentPriceCapacity > otherPriceCapacity) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return price < pendrive.getPrice();
    }
}
