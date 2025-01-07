package Buoi13.BaiKiemTraCuoiModul2;

import java.time.LocalDateTime;
import java.util.Map;

public class bankingSystem {
    private Map<String, Account> accounts;
    public bankingSystem(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public bankingSystem() {

    }

    //nạp tiền
    public void depositToAccount(String accountNumber, double amount) {
        // tìm kiếm tài khoản
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("không tìm thấy tài khoản với số tài khoản: " + accountNumber);
            return;
        }
        // kiểm tra số tiền cần nạp
        if (amount <= 0) {
            System.out.println("số tiền nạp phải lớn hơn 0. ");
            return;
        }
        //tạo giao dịch deposit
        Transaction transaction = new Transaction("T" + System.currentTimeMillis(),account,account.getEmployeeIncharge(),"deposit",amount, LocalDateTime.now());
        account.addTransaction(transaction); //lưu giao dịch vào lịch sử giao dịch của tài khoản
    }

    //rút tiền
    public void withdrawFromAccount(String accountNumber, double amount) {
        // tìm kiếm tài khoản
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("không tìm thấy tài khoản với số tài khoản : " + accountNumber);
            return;
        }
        //kiểm tra số tiền cần rút
        if (amount <= 0) {
            System.out.println("số tiền rút phải lớn hơn 0");
            return;
        } if (amount > account.getBalance()) {
            System.out.println("số dư tài khoản không đủ để thực hiện giao dịch");
            return;
        }
        //thực hiện giao dịch
        account.withdraw(amount);
        //tạo giao dịch withdraw
        Transaction transaction = new Transaction("T" + System.currentTimeMillis(),account,account.getEmployeeIncharge(),"withdraw",amount, LocalDateTime.now());
        //lưu giao dịch vào lịch sử giao dịch của tài khoản
        account.addTransaction(transaction);
    }

    //chuyển khoản
    public void transferMoney(String fromAccountNumber, String toAccountNumber, double amount) {
        // tìm kiếm tài khoản gửi và tài khoản nhận
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);
        if(fromAccount == null) {
            System.out.println("không tìm thấy tài khoản người gửi: " + fromAccountNumber);
            return;
        } if (toAccount == null) {
            System.out.println("không tìm thấy tài khoản người nhận: " + toAccountNumber);
            return;
        }
        //kiểm tra số tiền cần chuyển
        if (amount <= 0) {
            System.out.println("số tiền chuyển phải lớn hơn 0");
            return;
        } if (amount > fromAccount.getBalance()) {
            System.out.println("số dư tài Khoản không đủ để thực hiện giao dịch");
            return;
        }
        // thực hiện giao dịch
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        Transaction fromTransaction = new Transaction("T" + System.currentTimeMillis(),fromAccount,fromAccount.getEmployeeIncharge(),"transfer-out",amount, LocalDateTime.now());
        Transaction toTransaction = new Transaction("T" + System.currentTimeMillis(),toAccount,toAccount.getEmployeeIncharge(),"transfer-in",amount, LocalDateTime.now());
        toAccount.addTransaction(toTransaction);
        System.out.println("chuyển khoản thành công số tiền " + amount + " từ tài khoản " + fromAccountNumber + " đến tài khoản " + toAccountNumber );
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }
}
