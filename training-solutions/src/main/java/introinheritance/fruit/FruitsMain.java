package introinheritance.fruit;

public class FruitsMain {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        fruit.setName("Gyümölcs");
        fruit.setWeight(2);
        System.out.println(fruit.getName());
        System.out.println(fruit.getWeight());

        Grape grape = new Grape();
        grape.setName("Szőlő");
        grape.setType("Moon Drops");
        grape.setWeight(5);
        System.out.println(grape.getName());
        System.out.println(grape.getType());
        System.out.println(grape.getWeight());

        Apple apple = new Apple();
        apple.setName("Sima alma");
        apple.setWeight(1);
        apple.setPieces(10);
        System.out.println(apple.getName());
        System.out.println(apple.getWeight());
        System.out.println(apple.getPieces());

        GoldenDelicious goldenDelicious = new GoldenDelicious();
        goldenDelicious.setName("Golden");
        goldenDelicious.setWeight(5);
        goldenDelicious.setPieces(10);
        System.out.println(goldenDelicious.getName());
        System.out.println(goldenDelicious.getWeight());
        System.out.println(goldenDelicious.getPieces());
        System.out.println(goldenDelicious.getColour());

        Starking starking = new Starking();
        starking.setName("Starking");
        starking.setWeight(15);
        starking.setPieces(20);
        System.out.println(starking.getName());
        System.out.println(starking.getWeight());
        System.out.println(starking.getPieces());
        System.out.println(starking.getColour());

    }
}
