package junit5assert;

import java.util.Arrays;

public class Numbers {
    public int[] getEvenNumbers(int[] numbers) {
        int[] evenNumbers;
        evenNumbers = Arrays.copyOf(numbers,numbers.length);
        for (int i = 0; i < evenNumbers.length; i++) {
            if (evenNumbers[i] % 2 == 1) {
                evenNumbers[i] = 0;
            }
        }
        return evenNumbers;
    }
}
