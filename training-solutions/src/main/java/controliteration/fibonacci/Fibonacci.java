package controliteration.fibonacci;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c;
        int number;
        int i = 2;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Hány eleme legyen a Fibonacci sorozatnak? ");
        number = scanner.nextInt();

        System.out.println(System.lineSeparator() + "Megoldás do while ciklussal");
        System.out.print(a + ", " + b + ", ");
        do {
            c = a+b;
            System.out.print(c + ", ");
            a = b;
            b = c;
            i++;
        } while (i < number);

        a = 1;
        b = 1;
        System.out.println(System.lineSeparator() + "Megoldás for ciklussal");
        System.out.print(a + ", " + b + ", ");
        for (int j = 2; j < number; j++) {
            c = a+b;
            System.out.print(c + ", ");
            a = b;
            b = c;
        }

        a = 1;
        b = 1;
        System.out.println(System.lineSeparator() + "Megoldás while ciklussal");
        System.out.print(a + ", " + b + ", ");
        i = 2;
        while ( i < number) {
            c = a+b;
            System.out.print(c + ", ");
            a = b;
            b = c;
            i++;
        }
    }
}
