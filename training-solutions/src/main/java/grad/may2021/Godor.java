package grad.may2021;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Godor {

    private static GodorController godorController;
    private static Scanner scanner;
    private static int distance;
    private static int deepsNumber;
    private static GodorStartEnd godorStartEnd;

    public static void main(String[] args) {
        godorController = new GodorController();
        scanner = new Scanner(System.in);

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6a();
        exercise6b();
        exercise6c();
        exercise6d();
        exercise6e();
    }

    public static void exercise1() {
        System.out.println("1. feladat");
        godorController.readFile(Paths.get("src/main/resources/grad/melyseg.txt"));
        System.out.println("A fájl adatainak száma: " +godorController.getMelysegek().size());
    }

    public static void exercise2() {
        System.out.println("2. feladat");
        System.out.print("Adjon meg egy távolságértéket! ");
        distance = scanner.nextInt();
        int deep = godorController.queryDeepAtDistance(distance);
        System.out.printf("Ezen a helyen a felszín %d méter mélyen van.%n", deep);
    }

    public static void exercise3() {
        System.out.println("3. feladat");
        double ratio = godorController.queryUntouchedArea() / (double) godorController.getMelysegek().size() * 100;
        System.out.printf("Az érintetlen terület aránya %.2f%%.%n", ratio);
    }

    public static void exercise4() {
        System.out.println("4. feladat");
        deepsNumber = godorController.writeToFile(Path.of("src/main/resources/grad/godrok.txt"));
    }

    public static void exercise5() {
        System.out.println("5. feladat");
        System.out.printf("A gödrök száma: %d%n", deepsNumber);
    }

    public static void exercise6a() {
        System.out.println("6. feladat");
        System.out.println("a)");
        godorStartEnd = godorController.queryGodorStartEnd(distance);
        if (godorStartEnd.getStart() == -1) {
            System.out.println("Az adott helyen nincs gödör.");
        } else {
            System.out.printf("A gödör kezdete: %d méter, a gödör vége: %d méter.%n", godorStartEnd.getStart(), godorStartEnd.getEnd());
        }
    }

    public static void exercise6b() {
        System.out.println("b)");
        System.out.println(godorController.monotonicallyDeepens(godorStartEnd.getStart(), godorStartEnd.getEnd()) ? "Folyamatosan mélyül." :
                "Nem mélyül folyamatosan.");
    }

    public static void exercise6c() {
        System.out.println("c)");
        System.out.printf("A legnagyobb mélysége %d méter.%n", godorController.findDeepestPoint(godorStartEnd.getStart(), godorStartEnd.getEnd()));
    }

    public static void exercise6d() {
        System.out.println("d)");
        System.out.printf("A térfogata %d m^3.%n", godorController.calculateVolume(godorStartEnd.getStart(), godorStartEnd.getEnd()));
    }

    public static void exercise6e() {
        System.out.println("e)");
        System.out.printf("A vízmennyiség %d m^3.%n", godorController.calculateWaterVolume(godorStartEnd.getStart(), godorStartEnd.getEnd()));
    }
}
