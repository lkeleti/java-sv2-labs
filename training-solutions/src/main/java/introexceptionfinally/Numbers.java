package introexceptionfinally;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int number;
        boolean even = false;
        Scanner scanner = new Scanner(System.in);

        while (!even) {
            System.out.print("Kérem írjon be egy számot: ");
            String inputLine = scanner.nextLine();
            try {
                number = Integer.parseInt(inputLine);
                if (number % 2 == 0) {
                    even = true;
                }
            }
            catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Nem számot adott meg!");
            }
            finally {
                System.out.println("End of round.");
            }
        }
    }
}
