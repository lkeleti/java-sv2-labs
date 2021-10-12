package arrayofarrays;

public class Triangular {
    public int[][] triangularMatrix(int size) {
        int[][] tm = new int[size][];
        for (int i = 0; i < size; i++) {
            int[] innerArray = new int[i+1];
            for (int j = 0 ; j < i + 1; j++) {
                innerArray[j] = i;
            }
            tm[i] = innerArray;
        }
        return tm;
    }

    public static void main(String[] args) {
        ArrayOfArrays arrayOfArrays = new ArrayOfArrays();
        Triangular triangular = new Triangular();

        arrayOfArrays.printArrayOfArrays(triangular.triangularMatrix(5));
    }
}
