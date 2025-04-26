package workshop.bank.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super("예외발생: " + message);
    }
}
