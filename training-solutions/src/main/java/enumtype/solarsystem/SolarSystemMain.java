package enumtype.solarsystem;

public class SolarSystemMain {
    public static void main(String[] args) {
        System.out.println(SolarSystem.EARTH.getNumberOfMoons());

        for (SolarSystem item: SolarSystem.values()) {
            System.out.println(item.name() + "\t has " + item.getNumberOfMoons() + " moons.");
        }
    }
}
