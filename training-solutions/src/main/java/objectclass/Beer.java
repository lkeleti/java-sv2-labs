package objectclass;

public class Beer {
    private String name;
    private int price;

    public Beer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Beer beer = (Beer)obj;

        if (name != null && beer.name != null && name == beer.name && price == beer.price){
            return true;
        }
        return false;
    }
}
