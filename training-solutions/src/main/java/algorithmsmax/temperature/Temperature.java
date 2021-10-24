package algorithmsmax.temperature;

import java.util.List;

public class Temperature {
    public int getMin(List<Integer> temperatures) {
        int minValue = Integer.MAX_VALUE;
        for (int item: temperatures) {
            if (item < minValue) {
                minValue = item;
            }
        }
        return minValue;
    }
}
