package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store1 = new Store("Tea");
        Store store2 = new Store("Kávé");

        System.out.println(store1.getProduct() + " " + store1.getStock());
        System.out.println(store2.getProduct() + " " + store2.getStock());

        store1.store(10);
        store2.store(20);

        System.out.println(store1.getProduct() + " " + store1.getStock());
        System.out.println(store2.getProduct() + " " + store2.getStock());

        store1.dispatch(1);
        store2.dispatch(2);

        System.out.println(store1.getProduct() + " " + store1.getStock());
        System.out.println(store2.getProduct() + " " + store2.getStock());
    }
}
