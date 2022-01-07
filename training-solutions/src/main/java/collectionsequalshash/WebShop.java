package collectionsequalshash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebShop {
   List<Product> products = new ArrayList<>();

    public WebShop(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int findHowMany(Product product) {
        int counter = 0;
        for (Product p: products) {
            if (p.equals(product)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        WebShop webShop = new WebShop(
          new ArrayList<>(Arrays.asList(
                  new Product("SSD","1234"),
                  new Product("HDD","1235"),
                  new Product("Winchester","1235"),
                  new Product("Mainboard","1236")
          ))
        );

        System.out.println(webShop.findHowMany(new Product("Dataholder","1235")));
    }
}
