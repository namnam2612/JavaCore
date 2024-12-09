package Buoi6.BTVN.Bai2AndBai3;

import java.util.Date;

public class manageBankAccountInformation {
    private int id;
    private double balance; // số dư
    private double annuallnterestRate; // lãi suất
    private Date dateCreated; // ngày tạo tài khoản


    // hàm khởi tạo mặc định
    public manageBankAccountInformation() {
        this.id = 0;
        this.balance = 0.0;
        this.annuallnterestRate = 0.0;
        this.dateCreated = new Date();
    }

    //hàm khởi tạo với tham số
    public manageBankAccountInformation(int id, double balance, double annuallnterestRate, Date dateCreated) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
        this.dateCreated = new Date();
    }


    //getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    //phương thức  trả về lãi suất hàng tháng
    public double getMonthlyInterestRate() {
        return annuallnterestRate / 12 / 100;
    }

    // phương thức trả về tiền lãi hàng tháng
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    // phương thức rút tiền
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("khong du so du");
        } else {
            balance -= amount;
        }
    }

    // gửi tiền
    public void deposit(double amount) {
        balance += amount;
    }
}
