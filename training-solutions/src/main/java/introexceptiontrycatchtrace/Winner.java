package introexceptiontrycatchtrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Winner {

    private List<String> peoples = new ArrayList<>();

    public void addPeople(String name) {
        peoples.add(name);
    }

    public String getWinner() {
        Random random = new Random();
        int chosenPeople = random.nextInt(peoples.size());
        return peoples.get(chosenPeople).toUpperCase(Locale.ROOT);
    }
}
