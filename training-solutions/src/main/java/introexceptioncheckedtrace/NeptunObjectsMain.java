package introexceptioncheckedtrace;

import java.io.IOException;

public class NeptunObjectsMain {
    public static void main(String[] args) {
        NeptunObjets neptunObjets = new NeptunObjets();
        try {
            neptunObjets.prepareDatas("src/main/resources/neptun.csv");
            System.out.println(neptunObjets.getNeptunCodes());
        }
        catch (IOException ioe) {
            System.out.println("Hiba a fájl beolvasása közben!");
            ioe.printStackTrace();
        }
    }
}
