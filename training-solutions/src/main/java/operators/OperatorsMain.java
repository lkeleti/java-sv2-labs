package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();

        int i = 13;
        System.out.println(i + " in binary: " + Integer.toBinaryString(i));

        i = 10;
        System.out.println(i + " isEven: " + operators.isEven(i));
        i = 11;
        System.out.println(i + " isEven: " + operators.isEven(i));

        System.out.println(operators.getResultOfDivision(11,3));
        System.out.println(operators.getResultOfDivision(192, 7));

        String s = new String();
        System.out.println("A változó értéke: " + s + " (" + operators.isNull(s) + ")");
        s = null;
        System.out.println("A változó értéke: " + s + " (" + operators.isNull(s) + ")");

        System.out.println("A változó értéke: " + s + " (" + operators.isEmpty(s) + ")");
        s = "";
        System.out.println("A változó értéke: " + s + " (" + operators.isEmpty(s) + ")");
        s = "Nem üres";
        System.out.println("A változó értéke: " + s + " (" + operators.isEmpty(s) + ")");
    }
}
