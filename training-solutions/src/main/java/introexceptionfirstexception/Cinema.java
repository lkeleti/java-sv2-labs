package introexceptionfirstexception;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String filmTitle;
        int numberOfTickets;
        int numberOfRow;
        System.out.println("Mozijegy vásárláshoz kérem adja meg az alábbi adatait: ");
        System.out.print("Vásárló neve: ");
        name = scanner.nextLine();
        System.out.print("Film címe: ");
        filmTitle = scanner.nextLine();
        System.out.print("Hány jegyet szeretne vásárolni: ");
        numberOfTickets = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Hanyadik sorban szeretne ülni: ");
        numberOfRow = scanner.nextInt();
        scanner.nextLine();

        System.out.println("A mozijegy.hu rendszerben vásárolt jegyek adatai a következők:");
        System.out.println("Vásárló neve: " + name);
        System.out.println("Film címe: " + filmTitle);

        System.out.print("Lefoglalt helyek: ");
        for (int i = 0 ; i < numberOfTickets; i++) {
            if (i != numberOfTickets-1) {
                System.out.printf("%d. sor %d. szék, ", numberOfRow, i+1);
            }
            else {
                System.out.printf("%d. sor %d. szék", numberOfRow, i+1);
            }

        }
        System.out.println();
        System.out.println("Jó szórakozást!");
    }
}
