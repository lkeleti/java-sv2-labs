package introexceptionthrow;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();

        System.out.println("Üdvözöljük a regisztárciós rendszerben!");
        boolean goodName = false;
        String name = "";
        while (!goodName) {
            System.out.print("Kérem adja meg a nevét: ");
            name = scanner.nextLine();
            try {
                validation.validateName(name);
                goodName = true;
            }
            catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        boolean goodAge = false;
        String ageString = "";
        while (!goodAge) {
            System.out.print("Kérem adja meg az életkorát: ");
            ageString = scanner.nextLine();
            try {
                validation.validateAge(ageString);
                goodAge = true;
            }
            catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.println("Ön a következő adatokkal reisztrált!");
        System.out.println("\tNeve: " + name);
        System.out.println("\tÉletkora: " + ageString + " év.");

        System.out.println("Sikeresen regisztrált!");
    }
}
