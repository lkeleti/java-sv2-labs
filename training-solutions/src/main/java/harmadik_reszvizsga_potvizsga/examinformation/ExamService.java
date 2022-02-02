package harmadik_reszvizsga_potvizsga.examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ExamService {
    private Map<String, ExamResult> results = new TreeMap<>();
    private int theoryMax;
    private int practiceMax;

    public void readFromFIle(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            line = br.readLine();
            getMaxPoints(line);
            while ((line = br.readLine()) != null) {
                addToMap(line);
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: " + path,ioe);
        }
    }

    private void addToMap(String line) {
        String[] values = line.split(";");
        String[] resultValues = values[1].split(" ");
        results.put(values[0], new ExamResult(Integer.parseInt(resultValues[0]),Integer.parseInt(resultValues[1])));
    }

    private void getMaxPoints(String line) {
        String[] values = line.split(" ");
        theoryMax = Integer.parseInt(values[0]);
        practiceMax = Integer.parseInt(values[1]);
    }

    public Map<String, ExamResult> getResults() {
        return new TreeMap<>(results);
    }

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public List<String> findPeopleFailed() {
        return results.entrySet().stream()
                .filter(e->e.getValue().getTheory()/(double)theoryMax<0.51 || e.getValue().getPractice()/(double)practiceMax<0.51)
                .map(Map.Entry::getKey)
                .toList();
    }

    public String findBestPerson() {
        return results.entrySet().stream()
                .filter(e->e.getValue().getTheory()/(double)theoryMax>=0.51 && e.getValue().getPractice()/(double)practiceMax>0.51)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparingInt(e-> (practiceMax + theoryMax) - (e.getValue().getPractice()+e.getValue().getTheory())))
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
}
