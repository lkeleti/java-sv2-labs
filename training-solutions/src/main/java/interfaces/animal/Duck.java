package interfaces.animal;

public class Duck implements Animal{
    private final static int NUMBER_OF_LEGS = 2;
    private String name = "Duck";

    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    @Override
    public String getName() {
        return name;
    }
}
