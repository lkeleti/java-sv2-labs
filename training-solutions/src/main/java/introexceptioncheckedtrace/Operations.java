package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Operations {
    public List<String> readFile() throws IOException {
        return Files.readAllLines(Paths.get("src/main/resources/underground.txt"));
    }

    public String getDailySchedule(List<String> codes) {
        StringBuilder result = new StringBuilder(LocalDate.now() + ", ");
        for (String code: codes) {
            if (code.startsWith("2")) {
                result.append(code);
                result.append(" ");
            }
        }
        return result.toString();
    }
}
