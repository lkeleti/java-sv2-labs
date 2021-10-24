package compositionlist;

import java.util.ArrayList;
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
        if (!colours.isEmpty()) {
            colours.remove(0);
        }
    }
    public void removeLast() {
        if (!colours.isEmpty()) {
            colours.remove(colours.size() - 1);
        }
    }

    public List<String> getColors() {
        return colours;
    }
}
