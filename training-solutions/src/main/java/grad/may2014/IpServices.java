package grad.may2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IpServices {
    private List<String> ipAddressesAll = new ArrayList<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(path)))
        {
            String line;
            while ((line= br.readLine()) != null) {
                ipAddressesAll.add(line);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read from file!", ioe);
        }
    }

    public void exercise2() {
        System.out.printf("2. feladat:%nAz állományban %d darab adatsor van.%n", ipAddressesAll.size());
    }

    public void exercise3() {
        System.out.printf("3. feladat:%nA legalacsonyabb tárolt IP-cím:%n");
        System.out.println(ipAddressesAll.stream()
                .min(Comparator.comparing(i->i)).orElseThrow(()->new IllegalArgumentException("Something went wrong.")));
    }

    public void exercise4() {
        System.out.println("4. feladat:");
        System.out.printf("Dokumentációs cím: %d darab%n", ipAddressesAll.stream()
                .filter(i->i.startsWith("2001:0db8"))
                .count());
        System.out.printf("Globális egyedi cím: %d darab%n", ipAddressesAll.stream()
                .filter(i->i.startsWith("2001:0e"))
                .count());
        System.out.printf("Helyi egyedi cím: %d darab%n", ipAddressesAll.stream()
                .filter(i->i.startsWith("fc") || i.startsWith("fd"))
                .count());
    }

    public void exercise5(Path path) {
        System.out.println("4. feladat:");
        List<String> datas = ipAddressesAll.stream()
                .filter(this::isContainLeastEighteenZeros)
                .toList();
        try {
            Files.write(path, datas);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't write to file!", ioe);
        }
    }

    private boolean isContainLeastEighteenZeros(String ip) {
        return Stream.of(ip.split(""))
                .filter(c->c.equals("0"))
                .count() >= 18;
    }

    public static void main(String[] args) {
        IpServices ipServices = new IpServices();
        ipServices.readFromFile(Path.of("src/main/resources/grad/ip.txt"));
        ipServices.exercise2();
        ipServices.exercise3();
        ipServices.exercise4();
        ipServices.exercise5(Path.of("src/main/resources/grad/sok.txt"));
    }
}
