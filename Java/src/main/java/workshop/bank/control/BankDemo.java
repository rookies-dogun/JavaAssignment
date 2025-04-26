package workshop.bank.control;

import workshop.bank.entity.Bank;
import workshop.bank.entity.SavingAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("==== 계좌 생성 ====");
        bank.createSavingAccount("홍길동", 10000, 3.0);
        bank.createCheckAccount("홍길동", 20000, 5000);
        bank.createSavingAccount("이영희", 30000, 2.0);

        System.out.println("==== 모든 계좌 목록 ====");
        bank.printAllAccounts();

        System.out.println("==== 입금/출금 테스트====");
        bank.deposit("0", 5000);
        bank.withdraw("1", 3000);

        System.out.println("==== 이자 적용 테스트 ====");
        ((SavingAccount)bank.findAccount("0")).applyInterest();

        System.out.println("==== 계좌 이체 테스트 ====");
        bank.transfer("1","2", 5000);

        System.out.println("==== 예외 테스트 ====");
        try{
            bank.transfer("2","1", 30000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            bank.findAccount("20");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            bank.withdraw("1", 30000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
