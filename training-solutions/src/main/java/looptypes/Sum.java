package looptypes;

public class Sum {
    public void printSums(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            System.out.print(numbers[i-1] + numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        int[] n = {2, 6, 3, 5, 7, 9};
        sum.printSums(n);
    }
}
