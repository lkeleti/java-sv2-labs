package introexceptiontrycatchtrace;

import java.util.Scanner;

public class CalculatorMain {
    public Integer readNumber(Scanner scanner) {
        Integer number = null;
        System.out.print("Kérem írja be a számot amivel műveletet szeretne elvégezni: ");
        try {
            number = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Ez nem szám!");
            System.out.println(nfe.getMessage());
        }
        return number;
    }

    public static void main(String[] args) {
        final String RESULTSTRINGINTEGER = "%d %s %d művelet eredménye %d";
        final String RESULTSTRINGDOUBLE = "%d %s %d művelet eredménye %.4f";

        CalculatorMain calculatorMain = new CalculatorMain();
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Egyszerű számológép:");

        Integer numberOne = calculatorMain.readNumber(scanner);
        Integer numberTwo = calculatorMain.readNumber(scanner);

        if (numberOne != null && numberTwo != null) {
            System.out.println("Kérerm írja be, hogy milyen műveletet végezzek el az előbbi két számmal!");
            System.out.print("A következő 4 művelet közül választhat: (+ - * /)");

            String operationString = scanner.nextLine();
            char operation = 0;

            try {
                operation = operationString.charAt(0);
            }
            catch (StringIndexOutOfBoundsException siob) {
                System.out.println("Nem írt be érvényes műveletet!");
            }

            switch (operation) {
                case '+' :
                    System.out.printf(RESULTSTRINGINTEGER, numberOne, operation, numberTwo, calculator.sumNumbers(numberOne, numberTwo));
                    break;
                case '-' :
                    System.out.printf(RESULTSTRINGINTEGER, numberOne, operation, numberTwo, calculator.extractNumbers(numberOne, numberTwo));
                    break;
                case '*' :
                    System.out.printf(RESULTSTRINGINTEGER, numberOne, operation, numberTwo, calculator.multiplyNumbers(numberOne, numberTwo));
                    break;
                case '/':
                    System.out.printf(RESULTSTRINGDOUBLE, numberOne, operation, numberTwo, calculator.divideNumbers(numberOne, numberTwo));
                    break;
                default:
                    System.out.println("Nem írt be érvényes műveletet!");
            }
        }
        else {
            System.out.println("A számológép csak számokkal képes műveleteket végezni!");
        }
    }
}
