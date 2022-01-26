package lambdaprimitives;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
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
        return (int) (products.stream()
                .mapToInt(Product::getPieces)
                .sum()
        );
    }

    public double getAveragePrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics result = products.stream()
                .filter(p -> p.getPrice() > minPrice)
                .mapToInt(Product::getPieces)
                .summaryStatistics();
        if (result.getCount() == 0) {
            return "Nincs ilyen termék.";
        } else {
            return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.", result.getCount(), result.getMin(), result.getMax(), result.getSum());
        }
    }
}
