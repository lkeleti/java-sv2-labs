package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Electricity {
    private List<String> maintenanceList = new ArrayList<>();

    public Electricity(LocalDate date) {
        maintenanceList.add(date.toString());
    }

    public void addStreet(String street) {
        maintenanceList.add(street);
    }

    public void writeStreets(Path path) throws IOException {
        Files.write(path, maintenanceList);
    }
}
