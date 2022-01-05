package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }
}
