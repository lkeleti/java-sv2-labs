package algorithmsmax;

public class Plane {
    public int getLongestOcean(String map) {
        int longest = 0;
        char beforeValue = '1';
        int defaultDistance = 0;

        for (char c: map.toCharArray()) {
            if (c == '0') {
                if (beforeValue == '0') {
                    defaultDistance++;
                }
                else {
                    defaultDistance = 1;
                }
            }
            else {
                if (beforeValue == '0') {
                    if (defaultDistance > longest) {
                        longest = defaultDistance;
                    }
                    defaultDistance = 0;
                }
            }
            beforeValue = c;
        }
        return longest;
    }
}
