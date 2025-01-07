package Buoi13.BaiKiemTraCuoiModul2;

import java.time.LocalDateTime;

public class Transaction { // Giao dịch (quản lý thông tin giao dịch liên quan đến tài khoản)

    private String transactionId; // định danh mã giao dịch
    private Account account; // tài khoản liên quan đến giao dịch
    private Employee employee; // nhân viên thực hiện giao dịch
    private String type; // loại giao dịch (mô tả bản chất giao dịch)
    private double amount; // số tiền giao dịch
    private LocalDateTime timestamp; // thời gian thực hiện giao dịch
    private Account recipient;

    // Constructor duy nhất cho tất cả các loại giao dịch
    public Transaction(String transactionId, Account account, Employee employee, String type, double amount, LocalDateTime timestamp, Account recipient) {
        this.transactionId = transactionId;
        this.account = account;
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.recipient = recipient; // Chỉ gán recipient nếu là giao dịch Transfer
    }

    public Account getRecipient() {
        return recipient;
    }

    public void setRecipient(Account recipient) {
        this.recipient = recipient;
    }

    // contrucster
    public Transaction(String transactionId, Account account, Employee employee, String type, double amount, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.account = account;
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {// trả về chuỗi mô tả đầy đủ về đối tượng giao dịch

        if (recipient != null) {
            return "Transaction{" +
                    "transactionId='" + transactionId + '\'' +
                    ", account=" + account.getAccountNumber() +
                    ", employee=" + employee.getName() +
                    ", type='" + type + '\'' +
                    ", amount=" + amount +
                    ", timestamp=" + timestamp +
                    ", recipient=" + recipient.getAccountNumber() + // Thêm recipient
                    '}';
        } else {
            return "Transaction{" +
                    "transactionId='" + transactionId + '\'' +
                    ", account=" + account.getAccountNumber() +
                    ", employee=" + employee.getName() +
                    ", type='" + type + '\'' +
                    ", amount=" + amount +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
