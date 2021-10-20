package controlselection.week;

import java.util.Locale;

public class DayOfWeeks {
    public String partOfTheWeek(String day) {
        day = day.toLowerCase(Locale.ROOT);
        String result;
        switch (day) {
            case "hétfő":
                result = "hét eleje";
                break;
            case "kedd", "szerda", "csütörtök":
                result = "hét közepe";
                break;
            case "péntek":
                result = "majdnem hétvége";
                break;
            case "szombat", "vasárnap":
                result = "hét vége";
                break;
            default:
                result = "ismeretlen nap";
        }
        return result;
    }
}
