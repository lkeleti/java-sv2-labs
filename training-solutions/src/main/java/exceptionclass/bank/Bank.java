package exceptionclass.bank;

import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            throw new IllegalArgumentException("Account list should not be null!");
        }
        this.accounts = accounts;
    }
    public void payment(String accountNumber, double amount) {
        Account actualAccount = findAccount(accountNumber);
        if (actualAccount.getMaxSubtract() > amount) {
            actualAccount.subtract(amount);
        }
        else {
            throw new IllegalArgumentException("");
        }
    }

    public void deposit(String accountNumber, double amount) {
        Account actualAccount = findAccount(accountNumber);
        actualAccount.deposit(amount);
    }

    private Account findAccount(String accountNumber) {
        for (Account account: accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new InvalidAccountNumberBankOperationException("Invalid account number!");
    }
}
