package Buoi13.BaiKiemTraCuoiModul2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionManager {
    private Map<String, Account> accounts;
    private List<Transaction> allTransactions; // danh sách tất cả các giao dịch trong hệ thống
    private Transaction transaction;

    public TransactionManager(Map<String, Account> accounts) {
        this.accounts = accounts;
        this.allTransactions = new ArrayList<>();
    }

    public TransactionManager() {

    }

    //hiển thị lịch sử giao dịch một tài khoản
    public void displayTransactionHistory(String accountNumber) {
        //tìm kiếm tài khoản theo số tài khoản
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("không tìm thấy tài khoản vơới số tài khoản " + accountNumber);
            return;
        }
        List<Transaction> transactions = account.getTransactions(); //lấy danh sách giao dịch của tài khoản
        if (transactions == null || transactions.isEmpty()) {
            System.out.println("không có giao dịch nào cho tài khoản này");
            return;
        }
        //kiểm tra lịch sử giao dịch theo thứ tự thời gian (mới nhất lên trên)
        System.out.println("Lịch sử giao dịch cho tài khoản " + accountNumber + " là: ");
        for (Transaction transaction : transactions) {
            System.out.println("ID: " + transaction.getTransactionId() +
                    ", Loại: " + transaction.getType() +
                    ", Số tiền: " + transaction.getAmount() +
                    ", Thời gian: " + transaction.getTimestamp() +
                    ", Nhân viên: " + transaction.getEmployee().getName());
        }
    }

    //hiển thị tất cả giao dịch trong hệ thống
    public void displayAllTransactionHistory() {
        //kiểm tra nếu không có giao dịch nảo
        if(allTransactions.isEmpty()) {
            System.out.println("không có giao dịch nảo trong hệ thống");
            return;
        }
        // hiển thị thông tin tất cả giao dịch theo thứ tự thời gian (mới nhất lên truóc)
        System.out.println("danh sách toàn bộ giao dịch: ");
        for (Transaction transaction : allTransactions) {
            System.out.print("ID: " + transaction.getTransactionId() +
                    ", Loại: " + transaction.getType() +
                    ", Tài khoản: " + transaction.getAccount().getAccountNumber() +
                    ", Số tiền: " + transaction.getAmount() +
                    ", Thời gian: " + transaction.getTimestamp() +
                    ", Nhân viên: " + transaction.getEmployee().getName());
        }
        if (transaction.getRecipient() != null) {
            System.out.println(", tài khoản nhận " + transaction.getRecipient().getAccountNumber());
        }
        System.out.println();
    }


}
