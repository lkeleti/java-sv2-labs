package sorting.webshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WebShop {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProductsOrderByName() {
        List<Product> result = new ArrayList<>(products);
        Collections.sort(result, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return result;
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public List<Product> getProductsOrderByPrice() {
        List<Product> result = new ArrayList<>(products);
        Collections.sort(result, (o1, o2) -> o1.getPrice() - o2.getPrice());
        return result;
    }

    public List<Product> getProductsOrderByDate() {
        List<Product> result = new ArrayList<>(products);
        Collections.sort(result, (o1, o2) -> o1.getFrom().compareTo(o2.getFrom()));
        return result;
    }
}
