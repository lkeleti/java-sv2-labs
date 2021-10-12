package arrayofarrays;

public class DailyValues {
    public int[][] getValues() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][] calendar = new int[12][];

        for (int i = 0; i < numberOfDays.length; i++) {
            calendar[i] = new int[numberOfDays[i]];
        }
        return calendar;
    }

    public static void main(String[] args) {
        ArrayOfArrays arrayOfArrays = new ArrayOfArrays();
        DailyValues dailyValues = new DailyValues();
        int[][] calendar;
        calendar = dailyValues.getValues();
        arrayOfArrays.printArrayOfArrays(calendar);
    }
}
