package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        List<CatalogItem> toDelete = new ArrayList<>();
        for (CatalogItem catalogItem: catalogItems) {
            if (catalogItem.getRegistrationNumber().equals(registrationNumber)) {
                toDelete.add(catalogItem);
            }
        }
        catalogItems.removeAll(toDelete);
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem:catalogItems){
            if (catalogItem.hasAudioFeature()){
                result.add(catalogItem);
            }
        }
        return result;
    }

    private int collectAudioFeatures(List<Feature> features) {
        int sum = 0;
        for (Feature feature:features){
            if (feature instanceof AudioFeatures){
                sum += ((AudioFeatures) feature).getLength();
            }
        }
        return sum;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem:catalogItems){
            if (catalogItem.hasPrintedFeature()){
                result.add(catalogItem);
            }
        }
        return result;
    }

    private int collectPrintedFeatures(List<Feature> features) {
        int sum = 0;
        for (Feature feature:features){
            if (feature instanceof PrintedFeatures){
                sum += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return sum;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem catalogItem:catalogItems){
            if (catalogItem.hasPrintedFeature()){
                sum += collectPrintedFeatures(catalogItem.getFeatures());
            }
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem catalogItem:catalogItems){
            if (catalogItem.hasAudioFeature()){
                sum += collectAudioFeatures(catalogItem.getFeatures());
            }
        }
        return sum;
    }
}
