package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String birthDay;
        int numberOfPerson;
        List<String> datas = new ArrayList<>();

        System.out.print("Hány személy születésnapját szeretné rögzíteni? ");
        numberOfPerson = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfPerson; i++) {
            System.out.print("Kérem a nevet: ");
            name = scanner.nextLine();
            System.out.print("Kérem a születési időt: ");
            birthDay = scanner.nextLine();
            datas.add(name +": " + birthDay);
        }

        try {
            Files.write(Paths.get("src/main/resources/birthday.txt"), datas);
        }
        catch (IOException ioe) {
            System.out.println("Hiba a fájl írása közben!");
            ioe.printStackTrace();
        }
    }
}
