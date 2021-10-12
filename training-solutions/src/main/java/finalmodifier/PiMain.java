package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        System.out.println("A PI értéke: " + CircleCalculator.PI);
        CircleCalculator circleCalculator = new CircleCalculator();

        System.out.println("A kör kerülete: " + circleCalculator.calculatePerimeter(10));
        System.out.println("A kör területe: " + circleCalculator.calculateArea(10));

        CylinderCalculator cylinderCalculator = new CylinderCalculator();
        System.out.println("A henger térfogata: " + cylinderCalculator.calculateVolume(10,10));
        System.out.println("A henger felülete: " + cylinderCalculator.calculateSurfaceArea(10,10));

        CylinderCalculatorBasedOnCircle cylinderCalculatorBasedOnCircle = new CylinderCalculatorBasedOnCircle();
        System.out.println("A henger térfogata: " + cylinderCalculatorBasedOnCircle.calculateVolume(10,10));
        System.out.println("A henger felülete: " + cylinderCalculatorBasedOnCircle.calculateSurfaceArea(10,10));

    }
}
