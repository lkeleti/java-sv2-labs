package immutable.satellite;

public class CelestialCoordinates {
    private final int posX;
    private final int posY;
    private final int posZ;

    public CelestialCoordinates(int posX, int posY, int posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosZ() {
        return posZ;
    }

    @Override
    public String toString() {
        return "CelestialCoordinates: x=" + posX +
                ", y=" + posY +
                ", z=" + posZ;
    }
}
