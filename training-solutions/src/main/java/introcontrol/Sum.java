package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int summa = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i =0 ; i<5;i++) {
            System.out.println("Kérem adja meg az " + (i+1) + ". számot: ");
            summa += scanner.nextInt();
        }
        System.out.println("A számok összege: " + summa);
    }
}
