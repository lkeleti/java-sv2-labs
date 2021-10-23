package introexceptionreadfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Holiday {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("holiday.txt"));
            System.out.println(lines);
        }
        catch (IOException ioe)
        {
            System.out.println("Hiba történt a file olvasása közben!");
            ioe.printStackTrace();
        }
    }
}
