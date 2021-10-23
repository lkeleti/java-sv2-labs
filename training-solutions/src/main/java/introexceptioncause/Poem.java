package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Poem {
    private List<String> readFile(String fileName) {
        try {
           return Files.readAllLines(Paths.get(fileName));
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Hiba a fájl beolvasása közben!", ioe);
        }
    }

    public String getFirstChars(String fileName) {
        List<String> lines = readFile(fileName);
        char[] line = new char[lines.size()];
        for (int i = 0 ; i < lines.size(); i++) {
            line[i] = lines.get(i).charAt(0);
        }
        return new String(line);
    }
}
