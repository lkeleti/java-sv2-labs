package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Freezer {
    public static void main(String[] args) {
        List<String> freezer = new ArrayList<>();
        freezer.add("Banán");
        freezer.add("Sajt");
        freezer.add("Szalámi");
        freezer.add("Vaj");
        freezer.add("Retek");
        System.out.println(freezer.toString());
        System.out.println(freezer.size());

        freezer.remove(0);
        freezer.remove(2);
        System.out.println(freezer.toString());
        System.out.println(freezer.size());
    }
}
