package staticattrmeth.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankTransaction {

    private static final long MIN_TRX_VALUE = 1;
    private static final long MAX_TRX_VALUE = 10_000_000;

    private static long currentMinValue;
    private static long currentMaxValue;
    private static List<Long> transactions = new ArrayList<>();

    private long trxValue;

    private static void minAndMaxValue() {
        long minValue = transactions.get(0);
        long maxValue = transactions.get(0);

        for (long transaction: transactions) {
            if (transaction < minValue) {
                minValue = transaction;
            }
            if (transaction > maxValue) {
                maxValue = transaction;
            }
        }
        currentMinValue = minValue;
        currentMaxValue = maxValue;
    }

    public static void initTheDay() {
        transactions = new ArrayList<>();
        currentMaxValue = 0;
        currentMinValue = 0;
    }

    public static BigDecimal averageOfTransaction() {
        long sumOfTransactions = 0;

        for (long transaction: transactions) {
            sumOfTransactions += transaction;
        }
        return BigDecimal.valueOf(sumOfTransactions /transactions.size());
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        long sumOfTransactions = 0;

        for (long transaction: transactions) {
            sumOfTransactions += transaction;
        }
        return BigDecimal.valueOf(sumOfTransactions);
    }

    public BankTransaction(long trxValue) {
        if (trxValue < MIN_TRX_VALUE || trxValue > MAX_TRX_VALUE)
        {
            throw new IllegalArgumentException("This transaction cannot be excepted! " + trxValue);
        }
        else {
            transactions.add(trxValue);
            this.trxValue = trxValue;
            minAndMaxValue();
        }
    }

    public long getTrxValue() {
        return trxValue;
    }
}
