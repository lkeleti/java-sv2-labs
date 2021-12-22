package exceptions.sum;

public class NumbersSum {
    public int getSum(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("The parameter can't be null!");
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    public int getSum(String[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("The parameter can't be null!");
        }

        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            }
            catch ( NumberFormatException nfe) {
                throw new IllegalArgumentException("This is not a number: " + number,nfe);
            }
        }
        return sum;
    }
}
