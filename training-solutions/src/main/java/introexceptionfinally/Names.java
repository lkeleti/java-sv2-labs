package introexceptionfinally;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Names {
    public static void main(String[] args) {
        String name = "";

        try {
            List<String> names = Files.readAllLines(Paths.get("src/main/resources/names1.txt"));
            //List<String> names = Files.readAllLines(Paths.get("src/main/resources/names2.txt"));
            //List<String> names = Files.readAllLines(Paths.get("src/main/resources/names3.txt"));
            for (String item: names) {
                if (item.startsWith("dr")) {
                    name = item;
                    break;
                }
            }
            System.out.println(name);
        }

        catch (IOException ioe) {
            System.out.println("Hiba a fájl beolvasása közben!");
            ioe.printStackTrace();
        }
        finally {
            System.out.println("End of reading.");
        }
    }
}
