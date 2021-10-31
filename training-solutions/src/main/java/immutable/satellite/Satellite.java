package immutable.satellite;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (destinationCoordinates == null) {
            throw new IllegalArgumentException("Invalid coordinates!");
        }

        if (registerIdent == null || registerIdent.isEmpty()) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(destinationCoordinates.getPosX() + diff.getPosX(),
                destinationCoordinates.getPosY() + diff.getPosY(),
                destinationCoordinates.getPosZ() + diff.getPosZ());
    }

    @Override
    public String toString() {
        return getRegisterIdent() + ": " +
                "CelestialCoordinates: x=" + destinationCoordinates.getPosX()+
                ", y=" + destinationCoordinates.getPosY() +
                ", z=" + destinationCoordinates.getPosZ();
    }
}
