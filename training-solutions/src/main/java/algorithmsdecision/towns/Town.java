package algorithmsdecision.towns;

import java.util.List;

public class Town {
    public boolean containsFewerHabitants(List<Integer> populations, int minPopulation) {
        for (int item: populations) {
            if  (item < minPopulation) {
                return true;
            }
        }
        return false;
    }
}
