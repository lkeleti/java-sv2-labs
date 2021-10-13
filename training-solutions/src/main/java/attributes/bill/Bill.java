package attributes.bill;

public class Bill {
    public static void main(String[] args) {
        BillItem billItem = new BillItem("Kávé", 200, 2, 27);

        System.out.println("A termék neve: " + billItem.getProduct());
        System.out.println("Egységára: " + billItem.getPrice());
        System.out.println("Vásárolt mennyiség: " + billItem.getQuantity());
        System.out.println("Áfa (%): "  + billItem.getVatPercent());

        System.out.println("Teljes fizetendő: " + billItem.calculateTotalPrice());
    }
}
