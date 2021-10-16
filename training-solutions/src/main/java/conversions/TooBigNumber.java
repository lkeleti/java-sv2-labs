package conversions;

public class TooBigNumber {
    public long getRightResult(int number) {
        return (long)2_147_483_647 + number;
    }

    public static void main(String[] args) {
        TooBigNumber tooBigNumber = new TooBigNumber();
        System.out.println("2 147 483 647 számhoz adunk hozzá: " + tooBigNumber.getRightResult(2));
    }
}
