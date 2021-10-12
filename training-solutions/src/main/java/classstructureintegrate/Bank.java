package classstructureintegrate;

public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("10073217-12000098-67341590",
                "Tóth Kálmán",103400);

        System.out.println(bankAccount.getInfo());

        bankAccount.deposit(800);

        System.out.println(bankAccount.getInfo());

        bankAccount.withdraw(1000);

        System.out.println(bankAccount.getInfo());
    }
}
