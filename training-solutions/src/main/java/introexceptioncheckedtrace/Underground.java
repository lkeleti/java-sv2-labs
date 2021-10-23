package introexceptioncheckedtrace;

import java.io.IOException;

public class Underground {
    public static void main(String[] args) {
        Operations operations = new Operations();
        try{
            System.out.println(operations.getDailySchedule(operations.readFile()));
        }
        catch (IOException ioe) {
            System.out.println("Hiba a fájl feldolgozása közben!");
            ioe.printStackTrace();
        }
    }
}
