package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LostAndFoundOffice {
    private List<LostProperty> properties = new ArrayList<>();

    public void addProperty(LostProperty lostProperty) {
        properties.add(lostProperty);
    }
    public LostProperty findLostProperty(LostProperty lostProperty) {
        Collections.sort(properties);
        int result = Collections.binarySearch(properties,lostProperty);
        if (result < 0) {
            throw new IllegalArgumentException("Property not found.");
        }
        else {
            return properties.get(result);
        }
    }
}
