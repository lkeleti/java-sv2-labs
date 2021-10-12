package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adja meg a nevét: ");
        String name = scanner.nextLine();
        System.out.print("Kérem adja meg az email címét: ");
        String email = scanner.nextLine();
        System.out.println("Ön az alábbi adatokkal regisztrált: ");
        System.out.println("Neve: " + name);
        System.out.println("Email: " + email);
    }
}
