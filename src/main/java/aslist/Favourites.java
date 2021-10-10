package aslist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Favourites {
    public static void main(String[] args) {
        List<String> favouriteThings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mi a kedvenc filmed? ");
        favouriteThings.add(scanner.nextLine());

        System.out.print("Ki a kedvenc szinészed? ");
        favouriteThings.add(scanner.nextLine());

        System.out.print("A kedvenc állatod? ");
        favouriteThings.add(scanner.nextLine());

        System.out.println(favouriteThings.size());
        System.out.println(favouriteThings);
    }
}
