package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class ElectricityTest {
    @TempDir
    File temporaryFolder;


    @Test
    void fileWriteTest() throws IOException {
        Path path = temporaryFolder.toPath().resolve("maintenance.txt");
        Electricity electricity = new Electricity(LocalDate.now());
        electricity.addStreet("Petőfi u.");
        electricity.addStreet("Kossuth L. út");
        electricity.addStreet("Csokonai u.");

        electricity.writeStreets(path);

        List<String> maintenanceList = Arrays.asList(
                LocalDate.now().toString(), "Petőfi u.", "Kossuth L. út", "Csokonai u."
        );

        assertEquals(maintenanceList, Files.readAllLines(path));
    }
}
