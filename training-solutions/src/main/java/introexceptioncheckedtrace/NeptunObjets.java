package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NeptunObjets {
    private List<Person> persons = new ArrayList<>();

    private void readFile(String fileName) throws IOException {
        List<String> datas = Files.readAllLines(Paths.get(fileName));
        for (String data: datas) {
            String name = data.split(",")[0];
            String neptunCode = data.split(",")[1];
            persons.add(new Person(name, neptunCode));
        }
    }

    public void  prepareDatas(String fileName) throws IOException{
        readFile(fileName);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<String> getNeptunCodes() {
        List<String> neptunCodes = new ArrayList<>();
        for (Person person: persons) {
            neptunCodes.add(person.getNeptunCode());
        }
        return neptunCodes;
    }
}
