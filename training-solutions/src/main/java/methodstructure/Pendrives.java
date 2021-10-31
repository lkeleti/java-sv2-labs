package methodstructure;

import java.util.List;

public class Pendrives {
    public Pendrive best(List<Pendrive> pendrives) {
        if (pendrives == null || pendrives.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Pendrive best;
        if (pendrives.size() > 1) {
            best = pendrives.get(0);
            for (int i = 1; i < pendrives.size(); i++) {
                if (best.comparePricePerCapacity(pendrives.get(i)) == 1) {
                    best = pendrives.get(i);
                }
            }
            return best;
        }
        else {
            return pendrives.get(0);
        }
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        if (pendrives == null || pendrives.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Pendrive cheepestPendrive = pendrives.get(0);
        if (pendrives.size() > 1) {
            for (int i = 1; i < pendrives.size(); i++) {
                if (!cheepestPendrive.cheaperThan(pendrives.get(i))) {
                    cheepestPendrive = pendrives.get(i);
                }
            }
            return cheepestPendrive;
        }
        else {
            return pendrives.get(0);
        }
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        if (pendrives == null || pendrives.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < pendrives.size(); i++) {
            if (pendrives.get(i).getCapacity() == capacity) {
                pendrives.get(i).risePrice(percent);
            }
        }
    }
}
