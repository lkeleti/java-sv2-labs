package arrays;

import java.util.Arrays;

public class ArraysMain {
    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public String multiplicationTableAsString(int size) {
        int[][] multiplicationTable = new int[size][size];

        for (int i = 0; i < multiplicationTable.length; i++) {
            for (int j = 0; j < multiplicationTable[i].length; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(multiplicationTable);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day,anotherDay);
    }

    public int minValue(int value1, int value2) {
        if (value1 < value2) {
            return  value1;
        }
        else {
            return value2;
        }
    }

    public boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int numberOfDays = minValue(day.length,anotherDay.length);
        return Arrays.equals(Arrays.copyOfRange(day,0,numberOfDays),
                Arrays.copyOfRange(anotherDay,0,numberOfDays));
    }

    public boolean wonLottery(int[] played, int[] pulled) {
        int[] sortedPlayed = Arrays.copyOf(played, played.length);
        int[] sortedPulled = Arrays.copyOf(pulled, pulled.length);
        Arrays.sort(sortedPlayed);
        Arrays.sort(sortedPulled);
        return Arrays.equals(sortedPlayed, sortedPulled);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println(arraysMain.multiplicationTableAsString(9));

        double[] day = {20.0, 21.0, 22.0};
        double[] sameDay = {20.0, 21.0, 22.0};
        double[] anotherDay = {20.0, 21.0, 23.0};

        System.out.println(arraysMain.sameTempValues(day,sameDay));
        System.out.println(arraysMain.sameTempValues(day,anotherDay));

        double[] anotherLongDay = {20.0, 21.0, 23.0,30.5};
        double[] sameLongDay = {20.0, 21.0, 22.0, 30.5};

        System.out.println(arraysMain.sameTempValuesDaylight(day, sameLongDay));
        System.out.println(arraysMain.sameTempValuesDaylight(day, anotherLongDay));

        int[] played = {1, 2, 3, 4, 5};
        int[] pulled = {10, 70, 60, 50, 20};
        int[] winner = {70, 60, 10, 50, 20};

        System.out.println("Eredeti tipp: " + Arrays.toString(played));
        System.out.println("Húzott számok: " + Arrays.toString(pulled));
        System.out.println("Ötösünk lett? " + arraysMain.wonLottery(played,pulled));
        System.out.println("Vizsgálat utáni tipp: " + Arrays.toString(played));
        System.out.println("Vizsgálat utáni húzott számok: " + Arrays.toString(pulled));

        System.out.println("Nyeerő számok vizsgálata:");
        System.out.println("Eredeti nyerő tipp: " + Arrays.toString(winner));
        System.out.println("Húzott számok: " + Arrays.toString(pulled));
        System.out.println("Ötösünk lett? " + arraysMain.wonLottery(winner,pulled));
        System.out.println("Vizsgálat utáni nyerő tipp: " + Arrays.toString(winner));
        System.out.println("Vizsgálat utáni húzott számok: " + Arrays.toString(pulled));

    }
}
