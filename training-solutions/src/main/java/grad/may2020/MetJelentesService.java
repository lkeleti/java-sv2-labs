package grad.may2020;

import java.nio.file.Path;
import java.util.Scanner;

public class MetJelentesService {
    public static void main(String[] args) {
        Metjelentes metjelentes = new Metjelentes();
        metjelentes.readFromFile(Path.of("src/main/resources/grad/tavirathu13.txt"));
        metjelentes.exercise2();
        metjelentes.exercise3();
        metjelentes.exercise4();
        metjelentes.exercise5();
        metjelentes.exercise6("src/main/resources/grad/");
    }
}
