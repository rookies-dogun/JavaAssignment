package workshop.bank.entity;

public class SavingAccount extends Account{
    private double interestRate;


    public SavingAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        this.deposit(this.getBalance() / 100 * this.interestRate);


    }
    @Override
    public String toString() {
        return super.toString() + " ,  이자율: " + this.interestRate + "%";
    }
}
