package Buoi13.BaiKiemTraCuoiModul2;

import java.util.List;

public class Account { // quản lý thông tin tài khoan ngân hàng của khách hàng

    private String accountNumber; // số tài khoản duy nhất
    private String accountHolder; // tên chủ tài khoản
    private double balance; // số dư tài khoản
    private Employee employeeIncharge; // nhân viên phụ trách tài khoản
    private List<Transaction> transactions; // danh sách giao dịch liên quan

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Account(String accountNumber, String accountHolder, double balance, Employee employeeIncharge, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.employeeIncharge = employeeIncharge;
        this.transactions = transactions;
    }

    public Account(String accountNumber, String accountHolder, double balance, Employee employeeIncharge) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.employeeIncharge = employeeIncharge;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Employee getEmployeeIncharge() {
        return employeeIncharge;
    }

    public void setEmployeeIncharge(Employee employeeIncharge) {
        this.employeeIncharge = employeeIncharge;
    }

    // nạp tiền vào tài khoản
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("đã nạp số tiền " + amount + " vào tài khoản, số dư hiện tại là : " + balance);
        } else {
            System.out.println("số tiền nạp vào phải lớn hơn 0");
        }
    }

    // rút tiền
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("đã rút số tiền " + amount + " thành công. Số dư hiện tại là : " + balance);
        }else {
            System.out.println("số dư không đủ hoặc số tiền rút không hợp lệ");
        }
    }

    public void addTransaction(Transaction transaction) { // add giao dịch vào lịch sử giao dịch
        if (transactions == null) {
            transactions.add(transaction);
            System.out.println("Giao dịch đã được thêm vào tài khoản");
        } else {
            System.out.println("giao dịch không hợp lệ");
        }

    }
}
