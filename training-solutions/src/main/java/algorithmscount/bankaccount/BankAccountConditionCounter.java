package algorithmscount.bankaccount;

import java.util.List;

public class BankAccountConditionCounter {
    public int countWithBalanceGreaterThan (List<BankAccount> bankAccounts, int minBalance) {
        int counter = 0;
        for (BankAccount ba: bankAccounts) {
            if (ba.getBalance() > minBalance) {
                counter++;
            }
        }
        return counter;
    }
}
