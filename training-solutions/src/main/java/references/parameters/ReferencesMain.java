package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1;
        Person person2;
        person1 = new Person("John Doe", 40);
        person2 = person1;

        person2.setName("Jane Doe");

        System.out.println(person1.getName());
        System.out.println(person2.getName());
        /* Mivel mind a két változó ugyanaara az objektumra hivatkozik, ezért bármelyik setName()
        metódussal megváltoztathatom a nevét. Ugyanannak az objektumnak a name attributuma fog megváltozni.
        Kiiratáskor pedig bármelyik változóra meghívhatom a getName() metódust, ugyanannak az objektumnak
        a name attributumát fogja visszaadni.
         */

        int szam1;
        int szam2;
        szam1 = 24;
        szam2 = szam1;

        szam2++;

        System.out.println(szam1);
        System.out.println(szam2);

        /* szam1 és szam2 változók primitív típusúak, ezért a stacken a konkrét érték kerül eltárolásra
        amikor szam2-nek értékül adom a szam1-et, akkor nem referenciát adok át, hanem konkrét értéket,
        jelen esetben 24-et. Ha szam2 értékét 1-gyel növelem, akkor a stacken a 24-es értékből 25 lesz,
        míg a szam1 értéke marad továbbra is 24.
         */
        Person person3;
        person3 = new Person("Jim Beam", 65);
        person2 = person3;

        System.out.println("Első személy neve: " + person1.getName());
        System.out.println("Második személy neve: " + person2.getName());
        System.out.println("Harmadik személy neve: " + person3.getName());

        /* A referenciákat átcsoportosítottam, person1 esetében nem változott a referencia, ezért a
        korábbi értéket írattam ki. person2 viszont megkapta az újonnan létrehozott person3 referenciáját
        ezért mind a person2 és mind a person3 esetében ugyanarra a name attributumra hivatkozó getName()
        metódus visszatérési értékét irattam ki.
         */
    }
}
