package grad.may2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GodorController {
    private List<Integer> melysegek = new ArrayList<>();

    public void readFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            linsToList(lines);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file!",ioe);
        }
    }

    private void linsToList(List<String> lines) {
        for (String line : lines) {
            melysegek.add(Integer.parseInt(line));
        }
    }

    public List<Integer> getMelysegek() {
        return melysegek;
    }

    public int queryDeepAtDistance(int distance) {
        return melysegek.get(distance-1);
    }

    public int queryUntouchedArea() {
        int counter = 0;
        for (Integer melyseg: melysegek) {
            if (melyseg == 0) {
                counter++;
            }
        }
        return counter;
    }

    public int writeToFile(Path path) {
        List<String> lines = deepsToList();
        try {
            Files.write(path, lines);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot write to file!", ioe);
        }
        return lines.size();
    }

    private List<String> deepsToList() {
        List<String> lines = new ArrayList<>();
        String line = "";
        for (Integer melyseg: melysegek) {
            if (melyseg == 0){
                if (!line.isEmpty()) {
                    lines.add(line);
                    line = "";
                }
            }
            else {
                line += melyseg + " ";
            }
        }
        return lines;
    }
}
