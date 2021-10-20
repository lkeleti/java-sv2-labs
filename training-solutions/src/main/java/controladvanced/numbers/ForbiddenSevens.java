package controladvanced.numbers;

import java.util.Scanner;

public class ForbiddenSevens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Milyek számtól kezdjem a kiírást? ");
        int fromNumber = scanner.nextInt();
        scanner.nextLine();

        OUTER: while (true) {
            if (fromNumber % 7 == 0) {
                System.out.print("X ");
            }
            else {
               INNER: for (int i = 0 ; i < Integer.toString(fromNumber).length(); i++)
               {
                   if (Integer.toString(fromNumber).charAt(i) == '7') {
                       break OUTER;
                   }
               }
                System.out.print(fromNumber + " ");
            }
            fromNumber++;
        }
    }
}
