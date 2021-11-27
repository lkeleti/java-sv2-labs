package introinheritance.coffee;

public class CoffeeMain {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.setName("CAFFÈ LATTE");
        coffee.setPrice(500);
        System.out.println(coffee.getName());
        System.out.println(coffee.getPrice());

        Cappuccino cappuccino = new Cappuccino();
        cappuccino.setName("Cappuccini freddo");
        cappuccino.setPrice(200);
        System.out.println(cappuccino.getName());
        System.out.println(cappuccino.getPrice());
    }
}