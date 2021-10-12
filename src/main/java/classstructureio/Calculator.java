package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1;
        int number2;

        System.out.print("Kérem írja be az első összeadandó számot: ");
        number1 = scanner.nextInt();
        System.out.print("Kérem írja be a második összeadandó számot: ");
        number2 = scanner.nextInt();

        System.out.println(number1 + " + " + number2);
        System.out.println(number1+number2);
    }
}
