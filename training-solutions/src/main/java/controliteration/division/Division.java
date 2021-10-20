package controliteration.division;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adjon meg egy pozitív egész számot! A program ennél kisebb számokat fog kiírni. ");
        int maxNumber = scanner.nextInt();
        System.out.print("Hánnyal osztható számokat szeretne kapni? ");
        int dividedBy = scanner.nextInt();

        // Megoldás for ciklus használatával
        System.out.println("Megoldás for ciklussal");
        System.out.printf("%d-nél kisebb %d-vel osztható egész számok: ",maxNumber, dividedBy);
        for (int i = dividedBy; i < maxNumber; i+=dividedBy) {
            System.out.print(i + ", ");
        }
        System.out.println(System.lineSeparator());
        // Megoldás while ciklussal
        System.out.println("Megoldás while ciklussal");
        System.out.printf("%d-nél kisebb %d-vel osztható egész számok: ",maxNumber, dividedBy);
        int i = dividedBy;
        while (i < maxNumber) {
            System.out.print(i + ", ");
            i += dividedBy;
        }
        System.out.println(System.lineSeparator());
        // megoldás do while ciklussal
        System.out.println("Megoldás while ciklussal");
        System.out.printf("%d-nél kisebb %d-vel osztható egész számok: ",maxNumber, dividedBy);
        int j = dividedBy;
        do {
            System.out.print(j + ", ");
            j += dividedBy;
        } while (j < maxNumber);


    }
}
