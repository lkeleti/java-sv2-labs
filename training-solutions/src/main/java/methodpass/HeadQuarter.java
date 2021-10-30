package methodpass;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException();
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        moveTrooper(findTrooperByName(name),target);
    }

    public void moveClosestTrooper(Position target) {
        moveTrooper(findClosestTrooper(target),target);
    }

    private Trooper findTrooperByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Trooper trooper: troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        throw new IllegalArgumentException();
    }

    private Trooper findClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException();
        }
        Trooper closestTrooper = troopers.get(0);
        for (Trooper trooper: troopers) {
            if (trooper.distanceFrom(target) < closestTrooper.distanceFrom(target)) {
                closestTrooper = trooper;
            }
        }
        return closestTrooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        if (target == null || trooper == null) {
            throw new IllegalArgumentException();
        }
        trooper.changePosition(target);
    }
}
