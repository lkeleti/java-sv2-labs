package grad.may2021;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Godor {
    public static void main(String[] args) {
        GodorController godorController = new GodorController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. feladat");
        godorController.readFile(Paths.get("src/main/resources/grad/melyseg.txt"));
        System.out.println("A fájl adatainak száma: " +godorController.getMelysegek().size());

        System.out.println("2. feladat");
        System.out.print("Adjon meg egy távolságértéket! ");
        int distance = scanner.nextInt();
        int deep = godorController.queryDeepAtDistance(distance);
        System.out.printf("Ezen a helyen a felszín %d méter mélyen van.%n", deep);

        System.out.println("3. feladat");
        double ratio = godorController.queryUntouchedArea() / (double)godorController.getMelysegek().size()*100;
        System.out.printf("Az érintetlen terület aránya %.2f%%.%n", ratio);

        System.out.println("4. feladat");
        int deepsNumber = godorController.writeToFile(Path.of("src/main/resources/grad/godrok.txt"));

        System.out.println("5. feladat");
        System.out.printf("A gödrök száma: %d%n", deepsNumber);
    }
}
