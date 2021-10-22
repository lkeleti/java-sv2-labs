package introexceptionthrow;

import java.util.Scanner;

public class ShortWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérek egy legfeljebb 5 betűs szót: ");
        String word = scanner.nextLine();

        boolean notChar = false;
        for (char item: word.toCharArray()) {
            if (!Character.isAlphabetic(item)) {
                notChar= true;
            }
        }

        if (notChar) {
            throw new IllegalArgumentException("A szöveg nem csak betűket tartalmaz!");
        }

        if (word.length() > 5) {
            throw new IllegalArgumentException("A szöveg több, mint 5 betű hosszú!");
        }

        if (word.length() == 0 ) {
            throw new IllegalArgumentException("Nem írt be semmit!");
        }

        System.out.println("A beírt szó: "  + word);
    }
}
