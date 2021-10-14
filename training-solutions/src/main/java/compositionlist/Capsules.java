package compositionlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capsules {
    private List<String> colours = new ArrayList<>();

    public void addLast(String newColour) {
        colours.add(newColour);
    }
    public void addFirst(String newColour) {
        colours.add(0, newColour);
    }
    public void removeFirst() {
        colours.remove(0);
    }
    public void removeLast() {
        colours.remove(colours.size()-1);
    }

    public List<String> getColors() {
        return colours;
    }

}
