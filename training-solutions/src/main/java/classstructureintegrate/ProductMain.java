package classstructureintegrate;

public class ProductMain {
    public static void main(String[] args) {
        Product product = new Product("Kávé",100);

        System.out.println(product.getName());
        System.out.println(product.getPrice());

        product.increasePrice(200);

        System.out.println(product.getName());
        System.out.println(product.getPrice());

        product.decreasePrice(100);

        System.out.println(product.getName());
        System.out.println(product.getPrice());

    }
}
