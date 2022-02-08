package grad.may2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Metjelentes {

    private List<MetData> metDatas = new ArrayList<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                readFromLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void readFromLine(String line) {
        String[] datas = line.split(" ");
        metDatas.add(new MetData(
                datas[0],
                LocalTime.parse(datas[1].substring(0, 2) + ":" + datas[1].substring(2, 4)),
                datas[2].substring(0, 3),
                Integer.parseInt(datas[2].substring(3, 5)),
                Integer.parseInt(datas[3])
        ));
    }

    public void exercise2() {
        System.out.println("2. feladat");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adja meg egy település kódját! Település: ");
        String varos = scanner.nextLine();
        System.out.printf("Az utolsó mérési adat a megadott településről %s-kor érkezett.%n",
                metDatas.stream()
                        .filter(v -> v.getSettlement().equals(varos))
                        .sorted(Comparator.comparing(MetData::getTimeOfMeasurement).reversed())
                        .findFirst().orElseThrow()
                        .getTimeOfMeasurement()
        );
    }

    public void exercise3() {
        System.out.println("3. feladat");
        MetData minTemperature = metDatas.stream()
                .min(Comparator.comparingInt(MetData::getDegree))
                .orElseThrow();
        MetData maxTemperature = metDatas.stream()
                .max(Comparator.comparingInt(MetData::getDegree))
                .orElseThrow();
        System.out.printf("A legalacsonyabb hőmérséklet: %s %s %d fok.%n",
                minTemperature.getSettlement(), minTemperature.getTimeOfMeasurement(), minTemperature.getDegree());
        System.out.printf("A legmagasabb hőmérséklet: %s %s %d fok.%n",
                maxTemperature.getSettlement(), maxTemperature.getTimeOfMeasurement(), maxTemperature.getDegree());
    }

    public void exercise4() {
        System.out.println("4. feladat");
        List<MetData> noWind = metDatas.stream()
                .filter(m -> m.getWindDirection().equals("000") && m.getWindSpeed() == 0)
                .toList();
        if (noWind.isEmpty()) {
            System.out.println("Nem volt szélcsend a mérések idején.");
        } else {
            for (MetData metData : noWind) {
                System.out.println(metData.getSettlement() + " " + metData.getTimeOfMeasurement());
            }
        }
    }

    public void exercise5() {
        System.out.println("5. feladat");
    }

    public void exercise6() {
        System.out.println("6. feladat");
    }

    public void exercise7() {
        System.out.println("7. feladat");
    }

    public void exercise8(Path path) {
        System.out.println("8. feladat");
    }
}
