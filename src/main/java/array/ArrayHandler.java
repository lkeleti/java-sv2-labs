package array;

public class ArrayHandler {
    public void addIndexToNumber(int[] source) {
        for (int i = 0; i< source.length; i++) {
            source[i] += i;
        }
    }

    public void concatenateIndexToWord(String[] source) {
        for (int i = 0; i< source.length; i++) {
            source[i] = i + ". " + source[i];
        }
    }

    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();
        int[] numbers = {1, 2, 3, 4};
        String[] texts = {"Sunday", "Monday", "Tuesday"};
        arrayHandler.addIndexToNumber(numbers);
        for (int item: numbers) {
            System.out.println(item);
        }
        for (int item: numbers) {
            System.out.print(item + " ");
        }
        System.out.println("");

        arrayHandler.concatenateIndexToWord(texts);
        for (String item: texts) {
            System.out.println(item);
        }
        for (String item: texts) {
            System.out.print(item + " ");
        }
        System.out.println("");

    }
}
