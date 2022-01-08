package collectionslist;

import java.util.LinkedList;
import java.util.List;

public class BunchOfFlowers {
    private LinkedList<String> bunch = new LinkedList<>();

    public List<String> getBunch() {
        return new LinkedList<>(bunch);
    }

    public void addFlower(String flower) {
        bunch.add(flower);
    }

    public void addFlowerInTheMiddle(String flower){
        int numberOfFlowers = bunch.size();
        bunch.add(numberOfFlowers/2,flower);
        if (numberOfFlowers % 2 != 0 ) {
            bunch.add(numberOfFlowers/2+2,flower);
        }
    }
}
