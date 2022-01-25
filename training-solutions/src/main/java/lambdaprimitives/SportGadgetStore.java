package lambdaprimitives;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class SportGadgetStore {
    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int getNumberOfProducts() {
        return (int)(products.stream()
                .count());
    }

    public double getAveragePrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        DoubleSummaryStatistics result = products.stream()
                .filter(p->p.getPrice() > minPrice)
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
        return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.", 1,2,3,4);
    }
}
