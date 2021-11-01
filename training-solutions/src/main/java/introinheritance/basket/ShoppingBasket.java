package introinheritance.basket;

public class ShoppingBasket {
    private Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        // az összes tételre
        double sumOfNettoPrice = 0;
        for (Item item: basket.getItems()) {
            sumOfNettoPrice += item.getNettoPrice();
        }
        return sumOfNettoPrice;
    }

    public double sumTaxValue() {
        // az összes tételre
        double sumOfTax = 0;
        for (Item item: basket.getItems()) {
            sumOfTax += item.getTaxAmount();
        }
        return sumOfTax;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        // befejezzük a vásárlást, a kosár ürítése
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        // kikeresi és eltávolítja a kosárból a legdrágább tételt
        Item itemToRemove = basket.getItems().get(0);

        for (Item item: basket.getItems()) {
            if (item.getNettoPrice() > itemToRemove.getNettoPrice()) {
                itemToRemove = item;
            }
        }
        removeItem(itemToRemove.getBarcode());
    }
}
