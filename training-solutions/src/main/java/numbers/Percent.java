package numbers;

public class Percent {
    public double getValue(int firstNumber, int secondNumber) {
        return firstNumber /100D * secondNumber;
    }

    public double getBase(int number, int percent) {
        return number / (double) percent *100;
    }

    public  double getPercent(int firstNumber, int secondNumber) {
        return secondNumber / (double) firstNumber *100;
    }
    public static void main(String[] args) {
        Percent percent = new Percent();

        System.out.println(percent.getValue(127,27));
        System.out.println(percent.getBase(60,30));
        System.out.println(percent.getPercent(200,60));
    }
}
