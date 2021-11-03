package inheritancemethods.bankaccount;

public class DebitAccount {
    private String accountNumber;
    private long balance;

    private final double COST = 3.0;
    private final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public final long costOfTransaction(long amount){
        if (amount * COST/100 < MIN_COST) {
            return MIN_COST;
        }
        return (long) (amount * COST/100);
    }

    public boolean transaction(long amount){
        balance -= (amount+costOfTransaction(amount));
        if (balance < 0) {
            balanceToZero();
            return false;
        }
        return true;
    }

    public void balanceToZero() {
        // az egyenleget nullázza le, túlköltés esetén
        balance = 0;
    }
}
