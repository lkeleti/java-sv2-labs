package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount{
    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    public boolean transaction(long amount) {
        if (overdraftLimit + getBalance() -amount-costOfTransaction(amount) > 0) {
            if (amount+costOfTransaction(amount) <= getBalance()) {
                super.transaction(amount);
            }
            else {
                long remainingAmount = amount+costOfTransaction(amount) - getBalance();
                overdraftLimit -= remainingAmount;
                super.balanceToZero();
            }
            return true;
        }
        else {
            return false;
        }
    }
}
