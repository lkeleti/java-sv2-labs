package operators;

public class HeadingNorth {
    private int direction = 0;
    private int numberOfDirection = 0;

    public int getNumberOfNewDirections() {
        int value = 10;
        while (direction < 360) {
            direction += value;
            value += 10;
            numberOfDirection +=1;
        }
        return numberOfDirection;
    }
}
