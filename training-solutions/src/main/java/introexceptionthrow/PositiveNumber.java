package introexceptionthrow;

import java.util.Scanner;

public class PositiveNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem írjon be egy pozitív egész számot: ");
        String number = scanner.nextLine();

        for (char item: number.toCharArray()) {
            if (!Character.isDigit(item)) {
                throw new IllegalArgumentException("Nem pozitív szám!");
            }
        }
    }
}
