package methodparam.sums;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SeparatedSum {

    public Sums sum(String floatingNumbers) {
        Sums sums = new Sums(0,0);
        String[] datas = floatingNumbers.split(";");
        for (String data: datas) {
            parseNumber(data, sums);
        }
        return sums;
    }

    private void parseNumber(String data, Sums sums) {
        double number = Double.parseDouble(data.replace(",","."));
        if (number > 0) {
            sums.incSumPositives(number);
        }
        else {
            sums.incSumNegatives(number);
        }
    }

    public String readFromFile() {
        String line = "";
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/floatingnumbers.txt"));
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read File", ioe);
        }
        for (String l: lines) {
            line += l;
        }
        return line;
    }
}
