package lambdacomparator.cloud;

public enum PayPeriod {
    MONTHLY(12), ANNUAL(1), LIFETIME(60);

    private int length;

    PayPeriod(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
