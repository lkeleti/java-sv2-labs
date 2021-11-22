package staticattrmeth.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankTransaction {

    private static final long MIN_TRANSACTION_VALUE = 1;
    private static final long MAX_TRANSACTION_VALUE = 10_000_000;
    private static long countOfTransactions;
    private static long sumOfTransactions;
    private static long currentMinValue;
    private static long currentMaxValue;
    private long transactionValue;

    public BankTransaction(long transactionValue) {
        if (transactionValue < MIN_TRANSACTION_VALUE || transactionValue > MAX_TRANSACTION_VALUE) {
            throw new IllegalArgumentException("");
        }
        this.transactionValue = transactionValue;
        countOfTransactions++;
        sumOfTransactions += transactionValue;
    }

    public static void initTheDay(long minValue, long maxValue) {
        currentMinValue = minValue;
        currentMaxValue = maxValue;
    }

    public static long getAverageOfTransaction() {
        return sumOfTransactions/countOfTransactions;
    }

    public static long getCurrentMinValue(){
        return currentMinValue;
    }

    public static long getCurrentMaxValue(){
        return currentMaxValue;
    }

    public static long getSumOfTransactions(){
        return sumOfTransactions;
    }

    public long getTransactionValue() {
        return transactionValue;
    }
}
