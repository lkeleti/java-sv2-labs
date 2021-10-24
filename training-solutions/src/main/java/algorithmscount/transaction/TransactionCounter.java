package algorithmscount.transaction;

import java.util.List;

public class TransactionCounter {
    public int countEntryLessThan(List<Transaction> transactions, int maxCredit) {
        int counter = 0;
        for (Transaction transaction: transactions) {
            if (transaction.isCredit() && transaction.getAmount() < maxCredit) {
                counter++;
            }
        }
        return counter;
    }
}
