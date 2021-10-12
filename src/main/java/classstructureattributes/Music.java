package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem az előadót: ");
        song.band = scanner.nextLine();
        System.out.print("Kérem a szám címét: ");
        song.title = scanner.nextLine();
        System.out.print("Kérem a szám hosszát (percben): ");
        song.length = scanner.nextInt();

        System.out.println(System.lineSeparator());
        System.out.println(song.band + " - " + song. title + " (" +
                song.length + " perc)!");
    }
}
