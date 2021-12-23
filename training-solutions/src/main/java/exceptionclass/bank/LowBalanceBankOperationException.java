package exceptionclass.bank;

public class LowBalanceBankOperationException extends InvalidBankOperationException{
    public LowBalanceBankOperationException(String message) {
        super(message);
    }

    public LowBalanceBankOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
