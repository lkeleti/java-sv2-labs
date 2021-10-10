package aslist;

import java.util.Arrays;
import java.util.List;

public class Island {
    public static void main(String[] args) {
        List<String> importantThings = Arrays.asList("Tűlélőkészlet", "Műholdas telefon", "Bear Grylls");
        System.out.println(importantThings);

        importantThings.set(2,"Öngyújtó");
        System.out.println(importantThings);
    }
}
