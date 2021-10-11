package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {
    public static final List<String> WEEKDAYS = Arrays.asList("Hétfő", "Kedd", "Szerda",
            "Csütörtök", "Péntek", "Szombat", "Vasárnap");

    public static void main(String[] args) {
        Week.WEEKDAYS.set(1,"Szerda");
        System.out.println(Week.WEEKDAYS.toString());
    }
}
