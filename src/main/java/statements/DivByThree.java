package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem írjon be egy számot");

        int szam = scanner.nextInt();
        System.out.println(szam % 3 == 0 ? "Osztható" : "Nem osztható");
    }
}
