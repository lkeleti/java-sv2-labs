package statements;

public class Investment {
    double cost = 0.3;
    int fund;
    int interestRate;
    boolean active;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
        this.active = true;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days){
        return ((this.fund * (double)interestRate) / 100 * (double) days)/365;
    }

    public double close(int days) {
        boolean alreadyClosed = this.active;
        this.active = false;
        return alreadyClosed ? (this.getYield(days) + this.fund) * (1-(this.cost/100)) :0;
    }

}
