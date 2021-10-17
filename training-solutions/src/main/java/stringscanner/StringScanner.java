package stringscanner;

import java.util.Scanner;

public class StringScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem írjon be egy olyan mondatot, ami több tagmondatból áll: ");
        String sentence = scanner.nextLine();

        Scanner scannerByWords = new Scanner(sentence);
        while (scannerByWords.hasNext()) {
            System.out.println(scannerByWords.next());
        }

        System.out.print("Kérem írjon be egy olyan mondatot, ami több tagmondatból áll: ");
        sentence = scanner.nextLine();

        Scanner scannerByClause = new Scanner(sentence).useDelimiter(", ");
                while (scannerByClause.hasNext()) {
            System.out.println(scannerByClause.next());
        }
    }
}
