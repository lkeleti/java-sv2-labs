package numbers;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mi az eredménye a következő feladatnak?");
        System.out.print("1 + 2 * (3 / 5) = ");

        double answer = scanner.nextDouble();
        double result = 1 + 2 * (3 / 5D);
        if (Math.abs(answer - result) < 0.0001) {
            System.out.println("Jó megoldás.");
        }
        else {
            System.out.println("Sajnos ez nem sikerült");
        }
    }
}
