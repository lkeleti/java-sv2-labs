package finalmodifier;

public class CylinderCalculatorBasedOnCircle {
    public double calculateVolume(int r, int h) {

        return new CircleCalculator().calculateArea(r)*h;
    }

    public double calculateSurfaceArea(int r, int h) {

        return new CircleCalculator().calculatePerimeter(r)*(r+h);
    }
}
