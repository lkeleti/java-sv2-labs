package exceptions.measurement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Measurement {
    public List<String> readFromFile(Path path) {
        try {
            return(Files.readAllLines(path));
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    public List<String> validate(List<String> lines){
        List<String> result = new ArrayList<>();
        for (String line: lines) {
            String[] lineArray = line.split(",");
            if (lineArray.length != 3 ||
                    !checkInteger(lineArray[0]) ||
                    !checkDouble(lineArray[1]) ||
                    !checkName(lineArray[2])) {
                result.add(line);
            }
        }
        return result;
    }

    private boolean checkName(String s) {
        return (s == null || s.isEmpty() || s.contains(" "));
    }

    private boolean checkInteger(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private boolean checkDouble(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
