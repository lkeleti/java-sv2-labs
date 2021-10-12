package statements;

import java.util.Scanner;

public class InvestmentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Befektetés összege:");
        int fund = scanner.nextInt();

        System.out.println("Kamatláb:");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(fund,interestRate);

        System.out.println("Tőke: " + investment.getFund());
        int x = 50;
        System.out.println("Hozam "+ x +" napra: " + investment.getYield(x));
        int y = 80;
        System.out.println("Kivett összeg " +y+ " nap után: " + investment.close(y));
        int z = 90;
        System.out.println("Kivett összeg " +z+ " nap után: " + investment.close(z));
    }
}
