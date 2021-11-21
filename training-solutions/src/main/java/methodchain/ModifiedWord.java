package methodchain;

import java.util.Locale;

public class ModifiedWord {
    public String modify(String word) {
        return word.toUpperCase(Locale.ROOT).substring(0,4).charAt(0) + "x" + word.toUpperCase(Locale.ROOT).substring(0,4).charAt(2) + "y";
    }
}
