package stringscanner;

import java.util.Scanner;

public class IntScanner {
    public String convertInts(String ints) {
        Scanner scanner = new Scanner(ints).useDelimiter(";");
        StringBuilder result = new StringBuilder();

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number > 100) {
                result.append(Integer.toString(number));
                result.append(",");
            }
        }
        if (result.length() > 0) {
            result.delete(result.length()-1,result.length());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntScanner intScanner = new IntScanner();
        // A számsor több számból áll és van benne több (de legalább egy) szám, ami 100-nál nagyobb.
        System.out.println("Normál paraméter: " + intScanner.convertInts("5;3;107;12;123;18;198"));
        // A számsor összesen 1db, 100-nál nagyobb számból áll.
        System.out.println("1 db paraméter: " + intScanner.convertInts("198"));
        // A számsor tartalmaz több (vagy legalább egy) számot, de nincs benne 100-nál nagyobb szám.
        System.out.println("Nincs 100-nál nagyobb: " + intScanner.convertInts("5;3;7;12;23;18;98"));
        // A paraméterként megadott szöveg nem számsor, hanem üres String.
        System.out.println("Üres string: " + intScanner.convertInts(""));
    }
}
