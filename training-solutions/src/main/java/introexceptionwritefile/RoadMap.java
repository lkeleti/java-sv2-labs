package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RoadMap {
    public static void main(String[] args) {
        List<String> settlements = new ArrayList<>();
        settlements.add("Abony");
        settlements.add("Cegléd");
        settlements.add("Ceglédbercel");
        settlements.add("Albertirsa");
        settlements.add("Pilis");
        settlements.add("Monorierdő");
        settlements.add("Monor");
        settlements.add("Üllő");
        settlements.add("Vecsés");
        settlements.add("Budapest");

        try {
            Files.write(Paths.get("src/main/resources/roadmap.txt"), settlements);
        } catch (IOException ioe) {
            System.out.println("Hiba a fájl írása közben!");
            ioe.printStackTrace();
        }
    }
}
