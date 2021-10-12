package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem a nevét: ");
        client.name = scanner.nextLine();

        System.out.print("Kérem a születési évét: ");
        client.year = scanner.nextInt();

        client.address = scanner.nextLine();
        System.out.print("Kérem a címét: ");
        client.address = scanner.nextLine();

        System.out.println("A neve: " + client.name);
        System.out.println("A születési éve: " + client.year);
        System.out.println("A címe: " + client.address);
    }
}
