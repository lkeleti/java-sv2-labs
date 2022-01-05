package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {
    private String registrationNumber;
    private int price;
    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, List<Feature> features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features = features;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
