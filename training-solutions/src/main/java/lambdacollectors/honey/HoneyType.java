package lambdacollectors.honey;

public enum HoneyType {
    MULTIFLORAL(1200), ACACIA(1800), LINDEN(1500);

    private int  priceByKilograms;

    HoneyType(int priceByKilograms) {
        this.priceByKilograms = priceByKilograms;
    }

    public int getPriceByKilograms() {
        return priceByKilograms;
    }
}
