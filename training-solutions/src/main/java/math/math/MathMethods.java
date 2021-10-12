package math.math;

import java.util.Random;

public class MathMethods {
    public static void main(String[] args) {
        System.out.println(Math.max(1,2));
        System.out.println(Math.min(1,2));
        System.out.println(Math.PI);
        System.out.println(Math.round(Math.PI));
        System.out.println(Math.round(1.4142));
        System.out.println(Math.abs(-100));
        System.out.println(Math.negateExact(1));
        System.out.println(Math.addExact(3, 2));
        System.out.println(Math.subtractExact(2, 3));
        System.out.println(Math.multiplyExact(5, 5));
        System.out.println(Math.pow(3.3, 0.5));
        System.out.println(Math.incrementExact(0));
        System.out.println(Math.decrementExact(0));
        System.out.println(Math.random());
    }

}
