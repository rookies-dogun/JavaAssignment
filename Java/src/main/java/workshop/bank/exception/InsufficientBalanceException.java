package workshop.bank.exception;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super("예외발생: " + message);
    }

}
