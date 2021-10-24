package references.dogs;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        Dog dog1 = new Dog("Spániel", 2, "Fekete");
        Dog dog2 = new Dog("Vizsla", 4, "Barna");
        Dog dog3 = new Dog("Komondor", 6, "Fehér");

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        System.out.println(dogs);

        Dog dog4;
        dog4 = dogs.get(1);

        dog4.setColour("Lila");

        System.out.println(dogs);
        /* a dogs4 változó felvette a lista 1 indexű elemének a referenciáját, így amikor megváltoztattam
        a színt, akkor annak az objektumnak a colour attributumát változtattam meg, amelyre az 1 index
        hivatkozott és a dogs4 változó (a kettő ugyanaz).
         */

        Dog dog5;
        dog5 = new Dog("Tacskó",1,"Szürke");
        System.out.println(dog5);

        dog5 = dogs.get(1);
        // már nem tacskó!
        //System.out.println(dog5);

        dogs.add(dog5);

        System.out.println(dogs);
        // Az 1 indexű és az utolsó listaelem ugyanarra az objektumra hivetkozik.

        Dog dog6;
        dog6 = dog4;
        // dog4 az az objektum, ami a lista 1-es indexű és 3-as indexű helyén is meg van hivatkozva.

        dog6.setColour("Sárga");
        System.out.println(dogs);
        //Valóban megváltozott az 1 indexű és a 3 indexű listaelem színe

        List<Dog> dogs1;
        dogs1 = dogs;
        /* dogs és dogs1 ugyanazt a hivatkozást tartalmazza, mindegy, hogy mit csinálok az egyikkel
        az a másikra is hatással lesz
         */

        Dog dog7;
        dog7 = dog4;
        // Dog4, dog7 Listák 1 indexű és 3 indexű eleme ugyanarra az objektumra mutat

        dog7.setColour("Bíbor");
        System.out.println(dogs1);
        // Valóban megváltozott a színe az 1-es és 3-as indexű elemnek

        dog2.setColour("Fekete");
        //dog 2 a listák 1-es indexű elemére mutat még mindig

        System.out.println(dogs1);
        // Valóban megváltozott az 1-es és 3-as indexű elem színe

        dog2 = null;
        // Ez nincs hatással a listában tárolt hivatkozásra

        System.out.println(dogs1);
        // Valóban, a lista ettől nem változott

        Dog dog8;
        dog8 = dogs.get(1);
        dog8 = null;
        // Ennek nincs hatása a listákra

        System.out.println(dogs1);
        // Igazolódott, hogy nincs hatással a listára.

        Dog dog9;
        dog9 = dogs.get(1);
        dog9.setColour("Barna");

        // Ezzel mind a két listában átállítottam az 1-es és 3-as indexű elem színét

        System.out.println(dogs1);
        // Igazolódott. :)
    }
}
