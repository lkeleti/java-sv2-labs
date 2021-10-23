package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class PaulStreetBoys {
    private List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Hiba a fájl beolvasása közben!", ioe);
        }
    }

    public void writeAllNameToConsole(String fileName) {
        List<String> names = readFile(fileName);
        for (String name: names) {
            if (name.contains("Nemecsek")) {
                System.out.println(name.toLowerCase(Locale.ROOT));
            }
            else {
                System.out.println(name);
            }
        }
    }
}
