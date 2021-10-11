package finalmodifier;

public class TaxCalculator {
    public static final double TAX = 27.0;

    public double tax(double price) {
        return price / (1 + (TAX/100));
    }

    public double priceWithTax(double price) {
        return price * (1+ (TAX/100));
    }

    public static void main(String[] args) {
        TaxCalculator  taxCalculator = new TaxCalculator();
        System.out.println(taxCalculator.tax(127));
        System.out.println(taxCalculator.priceWithTax(100));
    }
}
