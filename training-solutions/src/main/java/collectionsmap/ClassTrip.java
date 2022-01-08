package collectionsmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassTrip {
    private Map<String, Integer> inpayments = new HashMap<>();

    public Map<String, Integer> getInpayments() {
        return inpayments;
    }

    public void loadInpayments(Path path) {
        List<String> lines = readFromFile(path);

        for (String line : lines) {
            String[] datas = line.split(": ");
            inpayments.put(datas[0], Integer.parseInt(datas[1]));
        }
    }

    private List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
}
