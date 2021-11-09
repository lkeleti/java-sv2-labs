package interfaces.animal;

public class Worm implements Animal{
    private final static int NUMBER_OF_LEGS = 0;
    private String name = "Worm";

    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    @Override
    public String getName() {
        return name;
    }
}