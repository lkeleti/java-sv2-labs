package composition.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Toldi Miklós", "12345678");
        System.out.println(person.personToString());
        System.out.println(person.getAddress());

        person.moveTo(new Address("Hungary","Kiskunhalas",
                "Petőfi u. 1.", "1234"));
        System.out.println(person.getAddress().addressToString());

        person.moveTo(new Address("Hungary", "Budapest",
                "Teréz krt. 1.", "1011"));

        System.out.println(person.getAddress().addressToString());
    }
}
