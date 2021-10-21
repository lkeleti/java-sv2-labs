package introexceptionmoreexceptions;

import java.util.Locale;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person(null, 32);

        System.out.println(person);
        System.out.println(person.getName());
        System.out.println(person.getName().toUpperCase(Locale.ROOT));
        // A toUpperCase üzenetnél keletkezik Cannot invoke "String.toUpperCase(java.util.Locale) kivétel
        // a null értékre nem lehet meghívni a metódust.

    }
}
