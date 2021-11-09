package interfaces.animal;

public class Lion implements Animal{
    private final static int NUMBER_OF_LEGS = 4;
    private String name = "Lion";

    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    @Override
    public String getName() {
        return name;
    }
}