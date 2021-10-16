package stringbasic.characters;

import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("A tanár írjon be egy szót: ");
        String word = scanner.nextLine();

        System.out.println("Az alábbi szót kell lebetűzni: " + word);

        String studentWord = "";
        for (int i = 0; i < word.length(); i++) {
            System.out.print("Kérem a következő betűt: ");
            String c = scanner.nextLine().substring(0,1);
            studentWord += c;
        }

        System.out.println("A tanuló az alábbi betűket adta meg: ");
        for (char c: studentWord.toCharArray()) {
            System.out.println("\t" + c);
        }

        System.out.println("Egybefűzve: " + studentWord);
        System.out.println(word.equals(studentWord) ? "Ez igen! Sikerült megoldani." : "Sajnos ez most nem jött össze.");
    }
}
