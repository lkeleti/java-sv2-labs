package collectionsqueue;

import java.util.*;

public class Vaccination {
    public Queue<Integer> getVaccinationOrder(List<Person> people) {
        Queue<Integer> result = new PriorityQueue<>();
        for (Person p: people) {
            if (p.getAge() > 18 &&  p. getAge() <= 65) {
                result.add(p.getAge());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Vaccination vaccination = new Vaccination();
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("John Doe",18),
                new Person("Jane Doe",20),
                new Person("Jack Doe",65),
                new Person("Peter Doe",70)
        ));
        Queue<Integer> toVaccinated =vaccination.getVaccinationOrder(people);
        System.out.println(toVaccinated);
        System.out.println(toVaccinated.poll());
    }
}
