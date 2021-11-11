package elso_reszvizsga_potvizsga.sumofdigits;

public class SumOfDigits {
    public int getSumOfDigits(int number) {
        String numberInString = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < numberInString.length();i++){
            sum += Integer.parseInt(String.valueOf(numberInString.charAt(i)));
        }
        return sum;
    }
}
