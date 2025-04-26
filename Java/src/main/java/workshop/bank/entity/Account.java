package workshop.bank.entity;

public class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber;}
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }
    public void deposit(double amount){
        this.balance += amount;
        System.out.println(amount + "원 이 입급되었습니다. 현재 잔액 : " + this.balance);
    }
    public void withdraw(double amount){
        this.balance -= amount;
        System.out.println(amount + "원 이 출금되었습니다. 현재 잔액 : " + this.balance);
    }

    @Override
    public String toString(){
        return "계좌 번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
    }

}
