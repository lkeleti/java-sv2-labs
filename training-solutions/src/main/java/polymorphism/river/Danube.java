package polymorphism.river;

import java.util.Arrays;
import java.util.List;

public class Danube extends River{
    private List<String> capitals;

    public Danube(String name, int length, List<String> capitals) {
        super(name, length);
        this.capitals = capitals;
    }

    public List<String> getCapitals() {
        return capitals;
    }

    public static void main(String[] args) {
        Water water = new Danube("Víz",500, Arrays.asList("Bécs", "Budapest"));
        River river = new Danube("Folyó",500, Arrays.asList("Bécs", "Budapest"));
        Danube danube = new Danube("Duna",500, Arrays.asList("Bécs", "Budapest"));

        System.out.println(water.toString());
        System.out.println(river.getName());
        System.out.println(river.getLength());

        System.out.println(danube.getName());
        System.out.println(danube.getLength());
        System.out.println(danube.getCapitals());
    }
}
