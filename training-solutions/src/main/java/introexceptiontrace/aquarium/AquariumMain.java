package introexceptiontrace.aquarium;

public class AquariumMain {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.addFish(new Fish("Blue marlin", "Blue"));
        aquarium.addFish(new Fish("Sockey salmon", "Red"));
        aquarium.addFish(new Fish("Cod", "Green"));

        System.out.println(aquarium.getNumberOfFish());
        /*
        A hibát az okozza, hogy az Aquarium osztályban található List<Fish> ornamentalFish attributum nincs példányosítva sehol.
        A megoldás lehet pl. ha a 6. sorában = new ArrayList<>(); paranccsal pédányosítjuk a Listát.
         */
    }

}
