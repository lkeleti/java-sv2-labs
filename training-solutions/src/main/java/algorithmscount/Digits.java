package algorithmscount;

public class Digits {
    public int getCountOfNumbers() {
        int counter = 0;
        for (int i = 10; i < 100; i++) {
            int firstNumber =  i/10;
            int secondNumber = i % 10;

            if(Math.abs(firstNumber-secondNumber) == 5) {
                counter++;
            }
        }
        return counter;
    }
}
