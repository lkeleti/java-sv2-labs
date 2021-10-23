package introexceptioncheckedtrace;

import java.io.IOException;

public class NeptunMain {
    public static void main(String[] args) {
        Neptun neptun = new Neptun();
        try {
            neptun.prepareDatas("neptun.csv");
            System.out.println(neptun.getNeptunCodes());
        }
        catch (IOException ioe) {
            System.out.println("Hiba a fájl beolvasása közben!");
            ioe.printStackTrace();
        }
    }
}
