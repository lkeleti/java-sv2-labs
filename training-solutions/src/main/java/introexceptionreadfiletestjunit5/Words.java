package introexceptionreadfiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Words {
    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Hiba a fájl beolvasásakor!",ioe);
        }
    }
    public String getFirstWordWithA(Path path) {
        List<String> words = readFile(path);
        String result = "A";
        for (String word: words) {
            if (word.startsWith("A")) {
                result = word;
                break;
            }
        }
        return result;
    }
}
