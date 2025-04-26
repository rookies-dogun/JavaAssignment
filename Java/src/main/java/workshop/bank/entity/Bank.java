package workshop.bank.entity;

import workshop.bank.exception.AccountNotFoundException;
import workshop.bank.exception.InsufficientBalanceException;
import workshop.bank.exception.WithdrawalLimitExceededException;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;
    private int nextAccountNumber;


    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 0;
    }


    public String createSavingAccount(String ownerName, double initBalance, double interestRate){
        SavingAccount savingAccount = new SavingAccount(String.valueOf(this.nextAccountNumber), ownerName, initBalance, interestRate);
        this.nextAccountNumber++;
        accounts.add(savingAccount);
        System.out.println("저축 계좌가 생성되었습니다: " + savingAccount);
        return savingAccount.toString();
    }

    public String createCheckAccount(String ownerName, double initBalance, double withdrawalLimit){
        CheckingAccount checkingAccount = new CheckingAccount(String.valueOf(this.nextAccountNumber), ownerName, initBalance, withdrawalLimit);
        this.nextAccountNumber++;
        accounts.add(checkingAccount);
        System.out.println("체킹 계좌가 생성되었습니다: " + checkingAccount);
        return checkingAccount.toString();
    }

    public Account findAccount(String accountNumber){
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + " 에 해당하는 계좌를 찾을 수 없습니다.");

    }

    public void deposit(String accountNumber, double amount){
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }
    public void withdraw(String accountNumber, double amount){
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount){
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if( amount > toAccount.getBalance() ){
            throw new InsufficientBalanceException("계좌 금액을 초과했습니다. 계좌 금액 : " + toAccount.getBalance() + "출금 금액 : " + amount);

        }
        toAccount.withdraw(amount);
        fromAccount.deposit(amount);
    }

    public void printAllAccounts(){
        for (Account account : accounts) {
            System.out.println(account);
        }
    }


}
