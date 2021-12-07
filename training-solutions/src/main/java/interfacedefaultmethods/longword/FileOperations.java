package interfacedefaultmethods.longword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public interface FileOperations {
    default List<String> readFromFile(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file!");
        }
        return lines;
    }

    String getLongWord();
}
