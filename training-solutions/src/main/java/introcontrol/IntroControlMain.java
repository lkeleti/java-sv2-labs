package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();

        System.out.println(introControl.subtractTenIfGreaterThanTen(5));
        System.out.println(introControl.subtractTenIfGreaterThanTen(15));

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(10));

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Jim"));

        System.out.println(introControl.calculateBonus(1000000));
        System.out.println(introControl.calculateBonus(2000000));
        System.out.println(introControl.calculateBonus(200));

        System.out.println(introControl.calculateConsumption(0,500));
        System.out.println(introControl.calculateConsumption(9000,900));

        introControl.printNumbers(5);

        introControl.printNumbersBetween(6,10);

        introControl.printNumbersBetweenAnyDirection(100,105);
        introControl.printNumbersBetweenAnyDirection(10,5);

        introControl.printOddNumbers(11);
    }
}
