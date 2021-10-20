package controliteration.exit;

import java.util.Scanner;

public class Exit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char key;

        do {
            System.out.print("Az ügyfélszolgálat menüje jelenleg nem elérhető. Kilépés: x billentyű megnyomásával. ");
            key = scanner.nextLine().charAt(0);
        } while (key != 'x');
    }
}
