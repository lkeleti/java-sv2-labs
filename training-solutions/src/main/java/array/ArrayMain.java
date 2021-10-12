package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] dayNames = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println(dayNames[1]);
        System.out.println(dayNames.length);

        int[] powerOfTwo = new int[5];
        int prev =1;
        for (int i = 0; i < powerOfTwo.length; i++) {
            powerOfTwo[i] = prev;
            prev *=2;
        }

        for (int item: powerOfTwo) {
            System.out.print(item + " ");
        }
        System.out.println("");

        boolean[] pattern = new boolean[6];
        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = i % 2 != 0;
        }

        for (int i = 0; i < pattern.length; i++) {
            if (i==0) {
                pattern[i] = false;
            }
            else {
                pattern[i] = !pattern[i-1];
            }
        }

        for (boolean item: pattern) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}
