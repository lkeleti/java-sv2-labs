package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrackPoints {
    private List<GpsInfo> gpsDatas = new ArrayList<>();

    private List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Hiba a fájl beolvasása közben!", ioe);
        }
    }

    public void readCords(String fileName) {
        List<String> lines = readFile(fileName);
        for (String line : lines) {
            String[] datas = line.split(";");
            gpsDatas.add(new GpsInfo(Double.parseDouble(datas[0]), Double.parseDouble(datas[1]), Integer.parseInt(datas[2])));
        }
    }

    public void writeLevelDifferences() {
        StringBuilder lines = new StringBuilder();
        int height = 0;
        for (int i = 0 ; i < gpsDatas.size(); i++) {
            if (i ==0) {
                height = gpsDatas.get(i).getHeight();
            }
            else {
                lines.append(gpsDatas.get(i).getHeight()-height);
                lines.append(System.lineSeparator());
                height = gpsDatas.get(i).getHeight();
            }
        }
        System.out.println(lines);
    }
}
