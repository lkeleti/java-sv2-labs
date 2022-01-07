package collectionsequalshash;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String taj;

    public Person(String name, int age, String taj) {
        this.name = name;
        this.age = age;
        this.taj = taj;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTaj() {
        return taj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return taj.equals(person.taj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taj);
    }

    public static void main(String[] args) {
        Person person1 = new Person("John Doe", 40,"12345678");
        Person person2 = new Person("Jane Doe", 40,"12345678");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
    }
}
