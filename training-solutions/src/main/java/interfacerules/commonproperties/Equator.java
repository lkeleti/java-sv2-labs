package interfacerules.commonproperties;

public class Equator implements Name, Length{
    private static final String NAME = "Equator";
    private static final Double LENGTH = 40_075.0;


    @Override
    public double getLength() {
        return LENGTH;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
