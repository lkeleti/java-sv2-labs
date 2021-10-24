package introexceptionwritefiletestjunit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ElectricityTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void fileWriteTest() throws IOException {
        Path path = temporaryFolder.newFile("maintenance.txt").toPath();
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
