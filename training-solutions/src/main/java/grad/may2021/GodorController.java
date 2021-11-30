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

    public GodorStartEnd queryGodorStartEnd(int position) {
        GodorStartEnd godorStartEnd = new GodorStartEnd();
        if (melysegek.get(position) == 0) {
            godorStartEnd.setStart(-1);
            godorStartEnd.setEnd(-1);
            return godorStartEnd;
        }
        godorStartEnd.setStart(findStart(position));
        godorStartEnd.setEnd(findEnd(position));
        return godorStartEnd;
    }

    private int findStart(int position) {
        for(int i = position; i > 0; i--){
            if (melysegek.get(i) > 0 && melysegek.get(i-1) == 0){
                return i+1;
            }
        }
        return 0;
    }

    private int findEnd(int position) {
        for(int i = position; i < melysegek.size()-1; i++){
            if (melysegek.get(i) > 0 && melysegek.get(i+1) == 0){
                return i+1;
            }
        }
        return melysegek.size();
    }

    public int findDeepestPoint(int start, int end) {
        int deepest = 0;
        for (int i = start; i <= end; i++) {
            if (melysegek.get(i) > deepest) {
                deepest = melysegek.get(i);
            }
        }
        return deepest;
    }

    public int calculateVolume(int start, int end) {
        int volume = 0;
        for (int i = start-1; i < end; i++) {
            volume += (melysegek.get(i) * 10);
        }
        return volume;
    }

    public int calculateWaterVolume(int start, int end) {
        int volume = 0;
        for (int i = start-1; i < end; i++) {
            if (melysegek.get(i) > 1) {
                volume += ((melysegek.get(i)-1) * 10);
            }
        }
        return volume;
    }
}
