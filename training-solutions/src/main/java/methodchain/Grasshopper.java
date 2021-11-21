package methodchain;

import static methodchain.Direction.NEGATIVE;
import static methodchain.Direction.POSITIVE;

public class Grasshopper {
    private int position;

    public Grasshopper hopOnce(Direction direction) {
        if (direction == POSITIVE) {
            position++;
        }
        else if (direction == Direction.NEGATIVE) {
            position--;
        }
        return this;
    }

    public void moveFromZeroToThreeWithFiveHops() {
        this.hopOnce(POSITIVE).hopOnce(POSITIVE).hopOnce(NEGATIVE).hopOnce(POSITIVE).hopOnce(POSITIVE);
    }

    public int getPosition() {
        return position;
    }
}
