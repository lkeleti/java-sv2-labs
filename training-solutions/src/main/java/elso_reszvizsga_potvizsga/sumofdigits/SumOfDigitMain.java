package elso_reszvizsga_potvizsga.sumofdigits;

public class SumOfDigitMain {
    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();

        System.out.println(sumOfDigits.getSumOfDigits(123456)); // 21
        System.out.println(sumOfDigits.getSumOfDigits(83)); // 11
        System.out.println(sumOfDigits.getSumOfDigits(987)); // 24
    }
}
