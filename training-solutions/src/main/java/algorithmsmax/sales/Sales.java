package algorithmsmax.sales;

import java.util.List;

public class Sales {
    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> sales) {
        Salesperson salespersonMaxSalesAmount = null;
        for (Salesperson item: sales) {
            if (salespersonMaxSalesAmount == null || item.getAmount() > salespersonMaxSalesAmount.getAmount()) {
                salespersonMaxSalesAmount = item;
            }
        }
        return salespersonMaxSalesAmount;
    }

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> sales) {
        Salesperson salespersonMaxAboveTarget = null;
        for (Salesperson item: sales) {
            if (salespersonMaxAboveTarget == null || item.getDifferenceFromTarget() > salespersonMaxAboveTarget.getDifferenceFromTarget()) {
                salespersonMaxAboveTarget = item;
            }
        }
        return salespersonMaxAboveTarget;
    }

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> sales) {
        Salesperson salespersonMaxUnderTarget = null;
        for (Salesperson item: sales) {
            if (salespersonMaxUnderTarget == null || item.getDifferenceFromTarget() < salespersonMaxUnderTarget.getDifferenceFromTarget()) {
                salespersonMaxUnderTarget = item;
            }
        }
        return salespersonMaxUnderTarget;
    }
}

