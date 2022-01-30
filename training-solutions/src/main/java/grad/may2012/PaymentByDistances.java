package grad.may2012;

public class PaymentByDistances {
    private int from;
    private int to;
    private int payment;

    public PaymentByDistances(int from, int to, int payment) {
        this.from = from;
        this.to = to;
        this.payment = payment;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getPayment() {
        return payment;
    }

    public boolean between(int distance) {
        return distance >= from && distance <= to;
    }
}
