package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null item not allowed!");
        }
        items.add(item);
    }

    public void removeItem(String barcode) {
        if (barcode == null || barcode.isEmpty() || barcode.isBlank()) {
            throw new IllegalArgumentException("Empty barcode not allowed!");
        }
        List<Item> toRemove = new ArrayList<>();
        for (Item item: items) {
            if (item.getBarcode().equals(barcode)) {
                toRemove.add(item);
            }
        }

        for (Item item: toRemove) {
            items.remove(item);
        }
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }
}
