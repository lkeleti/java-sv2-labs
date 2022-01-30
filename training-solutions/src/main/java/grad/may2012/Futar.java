package grad.may2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Futar {
    private List<DistanceData> distanceDatas = new ArrayList<>();
    private List<PaymentByDistances> paymentByDistances = new ArrayList<>();

    public Futar() {
        paymentByDistances.add(new PaymentByDistances(1, 2, 500));
        paymentByDistances.add(new PaymentByDistances(3, 5, 700));
        paymentByDistances.add(new PaymentByDistances(6, 10, 900));
        paymentByDistances.add(new PaymentByDistances(11, 20, 1400));
        paymentByDistances.add(new PaymentByDistances(21, 30, 2000));
    }

    private void readFromFile(Path path) {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datas = line.split(" ");
                distanceDatas.add(new DistanceData(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]), Integer.parseInt(datas[2])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read from file!", ioe);
        }
    }

    public void exercise1(Path path) {
        System.out.println("1. feladat");
        readFromFile(path);
        distanceDatas = distanceDatas.stream()
                .sorted(Comparator.comparingInt(DistanceData::getNumberOfDay).thenComparing(DistanceData::getNumberOfJob))
                .toList();
    }

    public void exercise2() {
        System.out.println("2. feladat");
        System.out.printf("A hét első útja %d km hosszú volt.%n", distanceDatas.get(0).getDistance());
    }

    public void exercise3() {
        System.out.println("3. feladat");
        System.out.printf("A hét utolsó útja %d km hosszú volt.%n", distanceDatas.get(distanceDatas.size() - 1).getDistance());
    }

    public void exercise4() {
        System.out.println("4. feladat");
        int elozo = 0;
        for (DistanceData distanceData : distanceDatas) {
            int actual = distanceData.getNumberOfDay();
            if (actual - elozo > 1) {
                System.out.printf("A futár szabadnapja a(z) %d. nap volt.%n", elozo + 1);
            }
            elozo = actual;
        }
    }

    public void exercise5() {
        System.out.println("5. feladat");
        System.out.printf("A futárnak a(z) %d. napon volt a legtöbb fuvarja.%n",
                distanceDatas.stream()
                        .max(Comparator.comparingInt(DistanceData::getNumberOfJob)).orElseThrow(() -> new IllegalStateException("Something went wrong")).getNumberOfDay()
        );
    }

    public void exercise6() {
        System.out.println("6. feladat");
        Map<Integer, Integer> summary = distanceDatas.stream()
                .collect(Collectors.groupingBy(DistanceData::getNumberOfDay, Collectors.summingInt(DistanceData::getDistance)));
        for (Map.Entry<Integer, Integer> entry : summary.entrySet()) {
            System.out.printf("%d. nap: %d km%n", entry.getKey(), entry.getValue());
        }
    }

    public void exercise7() {
        System.out.println("7. feladat");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adjon meg egy távolságot: ");
        int dist = Integer.parseInt(scanner.nextLine());
        System.out.printf("%d km távolságra %d Ft díjazás jár.%n", dist, getPayment(dist));
    }

    private int getPayment(int dist) {
        return paymentByDistances.stream()
                .filter(p -> p.between(dist))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong."))
                .getPayment();
    }

    public void exercise8(Path path) {
        System.out.println("8. feladat");
        List<String> dijazas = new ArrayList<>();
        distanceDatas
                .forEach(d-> dijazas.add(String.format("%d. nap %d. út: %d Ft", d.getNumberOfDay(), d.getNumberOfJob(),getPayment(d.getDistance()))));
        writeToFile(path, dijazas);
    }

    private void writeToFile(Path path, List<String> dijazas) {
        try {
            Files.write(path, dijazas);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't write to file!", ioe);
        }
    }

    public void exercise9() {
        System.out.println("9. feladat");
        System.out.printf("A futár %d Ft-ot kap a heti munkájáért",
                distanceDatas.stream()
                        .mapToInt(d->getPayment(d.getDistance()))
                        .sum()
                );
    }

    public static void main(String[] args) {
        Futar futar = new Futar();
        futar.exercise1(Path.of("src/main/resources/grad/tavok.txt"));
        futar.exercise2();
        futar.exercise3();
        futar.exercise4();
        futar.exercise5();
        futar.exercise6();
        futar.exercise7();
        futar.exercise8(Path.of("src/main/resources/grad/dijazas.txt"));
        futar.exercise9();
    }
}
