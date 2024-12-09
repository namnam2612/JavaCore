package Buoi6.BTVN.Bai2AndBai3;

public class accountTest extends manageBankAccountInformation {
    public static void main(String[] args) {
        manageBankAccountInformation account = new manageBankAccountInformation();

        //khởi tạo
        account.setId(1122);
        account.setBalance(20000);
        account.setAnnuallnterestRate(4.5);

        account.withdraw(2500); // rút tiền
        account.deposit(3000); // gửi tiền

        System.out.println("số dư hiện tại " + account.getBalance() + " usd");
        System.out.println("tiền lãi hàng tháng " + account.getMonthlyInterest() + " usd");
        System.out.println("ngày tạo tài khoản " + account.getDateCreated());


    }
}
