package methodpass;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position {
    private  double posX;
    private  double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        if (position == null) {
            throw new IllegalArgumentException();
        }
        return sqrt(pow(posX-position.getPosX(),2) + pow(posY-position.getPosY(),2));
    }
}
