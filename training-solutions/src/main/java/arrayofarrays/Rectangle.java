package arrayofarrays;

public class Rectangle {
    public int[][] rectangularMatrix(int size) {
        int [] [] rm = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rm[i][j] = i;
            }
        }
        return rm;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        int[][] rm = rectangle.rectangularMatrix(4);
        ArrayOfArrays arrayOfArrays = new ArrayOfArrays();
        arrayOfArrays.printArrayOfArrays(rm);
    }
}
