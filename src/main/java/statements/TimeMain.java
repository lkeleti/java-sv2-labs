package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        int h;
        int m;
        int s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem az első időponthoz tartozó óra értékét: ");
        h = scanner.nextInt();

        System.out.println("Kérem az első időponthoz tartozó perc értékét: ");
        m = scanner.nextInt();

        System.out.println("Kérem az első időponthoz tartozó másodperc értékét: ");
        s = scanner.nextInt();

        Time elsoIdo = new Time(h,m,s);

        System.out.println("Kérem a második időponthoz tartozó óra értékét: ");
        h = scanner.nextInt();

        System.out.println("Kérem a második időponthoz tartozó perc értékét: ");
        m = scanner.nextInt();

        System.out.println("Kérem a második időponthoz tartozó másodperc értékét: ");
        s = scanner.nextInt();

        Time masodikIdo = new Time(h,m,s);

        System.out.println("Az első időpont " + elsoIdo.toString() +" = " + elsoIdo.getInMinutes());
        System.out.println("A második időpont " + masodikIdo.toString() +" = " + masodikIdo.getInSeconds());
        System.out.println("Az első korábbi, mint a második: " + elsoIdo.earlierThan(masodikIdo));
    }
}
