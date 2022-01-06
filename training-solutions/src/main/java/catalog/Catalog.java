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

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem:catalogItems){
            if (catalogItem.hasPrintedFeature()){
                result.add(catalogItem);
            }
        }
        return result;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem catalogItem:catalogItems){
            if (catalogItem.hasPrintedFeature()){
                sum += catalogItem.numberOfPagesAtOneItem();
            }
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem catalogItem:catalogItems){
            if (catalogItem.hasAudioFeature()){
                sum += catalogItem.fullLengthAtOneItem();
            }
        }
        return sum;
    }

    public double averagePageNumberOver(int over){
        if (over <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        //ToDo
        return 0.0;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> result = new ArrayList<>();
        for (CatalogItem catalogItem: catalogItems) {
            if ((!searchCriteria.hasTitle() || catalogItem.getTitles().contains(searchCriteria.getTitle())) &&
                    (!searchCriteria.hasContributor() || catalogItem.getContributors().contains(searchCriteria.getContributor()))
            ) {
                result.add(catalogItem);
            }
        }
        return result;
    }
}
