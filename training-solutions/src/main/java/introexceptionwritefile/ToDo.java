package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ToDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> todos =  new ArrayList<>();

        String todo = "";
        System.out.println("Teendők rögzítése");
        System.out.println("Ha minden adatot bevitt, akkor x-et beírva fájlba írom a teendőket.");
        while (!todo.toUpperCase(Locale.ROOT).equals("X")) {
            System.out.print("Kérem a teendőt: ");
            todo = scanner.nextLine();
            if (!todo.toUpperCase(Locale.ROOT).equals("X")) {
                todos.add(todo);
            }
        }
        try {
            Files.write(Paths.get("src/main/resources/todos.txt"), todos);
        }
        catch (IOException ioe) {
            System.out.println("Hiba a fájl írása közben!");
            ioe.printStackTrace();
        }
    }
}
