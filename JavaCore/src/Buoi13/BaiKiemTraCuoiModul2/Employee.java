package Buoi13.BaiKiemTraCuoiModul2;

import java.util.List;

public class Employee { // quản lý thông tin nhân viên của ngân hàng

    private String id; // id nhân viên
    private String name; // tên nhân viên
    private double salary; // lương cơ bản
    private List<Account> managedAccounts; // danh sách tài khoản mà nhân viên quản lý

    public double calculateBonus() {
        return this.salary * 0.1;
    }

    public void addAccount(Account account) {
        if (account != null) {
            managedAccounts.add(account);
            System.out.println("đã thêm tài khoản vào danh sách quản lý của nhân viên");
        } else {
            System.out.println("tài khoản không hợp lệ !");
        }
    }

    public void processTransaction (Transaction transaction) {
        if (transaction != null) {
            for (Account account : managedAccounts) {
                if (account.getAccountNumber().equals(transaction.getTransactionId())) {
                    if ("deposit".equalsIgnoreCase(transaction.getType())) {
                        account.deposit(transaction.getAmount());
                    } else if ("withdraw".equalsIgnoreCase(transaction.getType())) {
                        try {
                            account.withdraw(transaction.getAmount());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    return;
                }
            }
            System.out.println("giao dịch không tìm thấy tài khoản phù hợp");
        } else {
            System.out.println("giao dịch không hợp lệ");
        }
    }

    public Employee(String id, String name, double salary, List<Account> managedAccounts) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.managedAccounts = managedAccounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Account> getManagedAccounts() {
        return managedAccounts;
    }

    public void setManagedAccounts(List<Account> managedAccounts) {
        this.managedAccounts = managedAccounts;
    }
}
