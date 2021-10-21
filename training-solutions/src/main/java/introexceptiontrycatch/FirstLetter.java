package introexceptiontrycatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLetter {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("abroad", "accept","access", "across", "acting", "action",
                "battle", "beauty", "became", "become", "before", "behalf", "behind", "belief", "belong", "berlin",
                "better", "beyond", "bishop","border", "bottle", null));
        try {
            for (String item : words) {
                System.out.println(item.charAt(0));
            }
        }
        catch (NullPointerException npe) {
            System.out.println("Hiba: A String null értéket tartalmazott!");
            System.out.println(npe.getMessage());
        }
    }

}
