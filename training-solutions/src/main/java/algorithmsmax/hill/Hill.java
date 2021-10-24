package algorithmsmax.hill;

import java.util.List;

public class Hill {
    public int getMax(List<Integer> hillHeights) {
        int maxValue = Integer.MIN_VALUE;
        for (int item: hillHeights) {
            if (item > maxValue) {
                maxValue = item;
            }
        }
        return maxValue;
    }
}
