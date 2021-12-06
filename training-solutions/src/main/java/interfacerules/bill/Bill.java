package interfacerules.bill;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Bill {
    public List<String> readBillItemsFromFile(Path path){
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file!", ioe);
        }
        return lines;
    }
}
