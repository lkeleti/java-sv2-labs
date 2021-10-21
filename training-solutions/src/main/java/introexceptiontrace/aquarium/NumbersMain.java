package introexceptiontrace.aquarium;

import java.util.Arrays;

public class NumbersMain {
    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(Arrays.toString(change.changeNumbers()));
        /*
        A hiba a RandomOperations osztályban a getNumbers metódusban található for (int i = 0; i <= lengthOfArray; i++)
        sorban található: 11. sor.
        Mivel az i értékét <= jellel vizsgálja a ciklus, ezért a tömb méreténél nagyobb értéket is felvesz az i változó értékül,
        Ezért a következő 12. sorban ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10 kivétel keletkezik.
         */
    }
}
