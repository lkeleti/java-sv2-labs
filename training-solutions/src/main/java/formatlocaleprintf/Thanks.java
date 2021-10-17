package formatlocaleprintf;

import java.util.ArrayList;
import java.util.List;

public class Thanks {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Abay Gyula");
        names.add("Abday Sándor");
        names.add("Abonyi Géza");
        names.add("Abonyi Tivadar");
        names.add("Ábrahám István");
        names.add("Ács János");
        names.add("Ács Norbert");
        names.add("Ádám Tamás");
        names.add("Adányi Alex");
        names.add("Ádok Zoltán");
        names.add("Adorjáni Bálint");
        names.add("Agárdi László");
        names.add("Agárdy Gábor");
        names.add("Ághy Sándor");
        names.add("Ágoston Péter");
        names.add("Ajtai Andor György");
        names.add("Ajtay Andor");
        names.add("Alapi Nándor");
        names.add("Albert Gábor");
        names.add("Albert Péter");
        names.add("Albisi László");

        for (String name: names) {
            System.out.printf("Kedves %s! Örülünk, hogy termékünket választotta!" + System.lineSeparator(), name);
        }
    }
}
