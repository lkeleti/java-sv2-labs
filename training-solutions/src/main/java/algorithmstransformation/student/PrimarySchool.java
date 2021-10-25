package algorithmstransformation.student;

import java.util.ArrayList;
import java.util.List;

public class PrimarySchool {
    List<Person> personList;

    public PrimarySchool(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (Person person: personList) {
            if (person.getAge() <= 14) {
                students.add(new Student(person.getName(),person.getAddress()));
            }
        }
        return students;
    }
}
