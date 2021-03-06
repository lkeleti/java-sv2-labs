package composition.person;

public class Person {
    private String name;
    private String identificationCard;
    private Address address;

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void correctData(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public void moveTo(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }

    public String personToString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", identificationCard='" + identificationCard + '\'' +
                '}';
    }
}
