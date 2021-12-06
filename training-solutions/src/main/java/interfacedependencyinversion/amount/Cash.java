package interfacedependencyinversion.amount;

public class Cash implements Payable{
    @Override
    public int getPayableAmount(int amount) {
        int lastNumber = amount % 10;
        switch (lastNumber){
            case 1,6:
                amount -= 1;
                break;
            case 2,7:
                amount -= 2;
                break;
            case 3,8:
                amount += 2;
                break;
            case 4,9:
                amount += 1;
                break;
        }
        return amount;
    }
}
