package algorithmscount.height;

import java.util.List;

public class Height {
    public int countChildrenWithHeightGreaterThan(List<Integer> childrenHeights, int minHeight) {
        int counter = 0;
        for (Integer height: childrenHeights) {
            if (height > minHeight) {
                counter++;
            }
        }
        return counter;
    }
}
