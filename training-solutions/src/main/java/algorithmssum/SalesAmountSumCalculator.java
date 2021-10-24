package algorithmssum;

import java.util.List;

public class SalesAmountSumCalculator {
    public int sumSalesAmount(List<Salesperson> salesPersons) {
        int sumOfAmount = 0;
        for (Salesperson sp: salesPersons) {
            sumOfAmount += sp.getAmount();
        }
        return sumOfAmount;
    }
}
