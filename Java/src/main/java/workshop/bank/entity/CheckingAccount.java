package workshop.bank.entity;

import workshop.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {

    private double withdrawalLimit;


    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    // 인출하다
    @Override
    public void withdraw(double amount) {
        if(amount > this.withdrawalLimit) {
            throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도 : " + withdrawalLimit);
            // 계좌 출금 한도보다 클 때
        }else if (amount > this.getBalance()){
            throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도 : " + withdrawalLimit);
            // 계좌 총 금액보다 클 때

        }else{
            super.withdraw(amount);

        }
    }

    @Override
    public String toString() {
        return super.toString() + " , 출금 한도: " + this.withdrawalLimit + "원";
    }
}
