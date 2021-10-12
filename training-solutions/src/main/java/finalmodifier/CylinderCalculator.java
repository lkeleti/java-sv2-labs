package finalmodifier;

public class CylinderCalculator {
    public double calculateVolume(int r, int h) {

        return r*r*CircleCalculator.PI*h;
    }

    public double calculateSurfaceArea(int r, int h) {

        return 2*r*CircleCalculator.PI*(r+h);
    }
}
