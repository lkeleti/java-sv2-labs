package harmadik_reszvizsga_pot_potvizsga.skirental;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SkiRental {
    private Map<String, Equipment> rentals = new TreeMap<>();

    public Map<String, Equipment> getRentals() {
        return new TreeMap<>(rentals);
    }

    public void loadFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                readFromLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file: " + path);
        }
    }

    private void readFromLine(String line) {
        String[] datas = line.split(";");
        String key = datas[0];
        String[] equipmentData = datas[1].split(" ");
        rentals.put(key,new Equipment(Integer.parseInt(equipmentData[0]), Integer.parseInt(equipmentData[1])));
    }

    public List<String> listChildren() {
        return rentals.entrySet().stream()
                .filter(r->((r.getValue().getSizeOfSkis() <= 120  && r.getValue().getSizeOfSkis() > 0) || (r.getValue().getSizeOfBoot() < 37 && r.getValue().getSizeOfBoot() > 0)) )
                .map(r->r.getKey())
                .toList();
    }

    public String getNameOfPeopleWithBiggestFoot() {
        return rentals.entrySet().stream()
                .filter(r->r.getValue().getSizeOfSkis() != 0)
                .max(Comparator.comparingInt(r->r.getValue().getSizeOfBoot()))
                .orElseThrow(()->new IllegalStateException("List is empty!")).getKey();
    }
}
