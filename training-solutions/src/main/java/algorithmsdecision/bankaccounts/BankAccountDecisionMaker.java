package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {
    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int min) {
        for (BankAccount bankAccount: accounts) {
            if (bankAccount.getBalance() >min) {
                return true;
            }
        }
        return false;
    }
}
