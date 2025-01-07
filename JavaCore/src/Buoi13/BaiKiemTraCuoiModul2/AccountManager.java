package Buoi13.BaiKiemTraCuoiModul2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManager {
    private Map<String, Account> accounts = new HashMap<>(); //lưu danh sách tài khoản
    private List<Employee> employees;

    public AccountManager(List<Employee> employees) {
        this.employees = employees;
    }

    // thêm tài khoản
    public void addAccount(String accountNumber, String accountHolder, double balance, String employeeId) {
        // kiểm tra số tài khoản đã tồn tại
        if(accounts.containsKey(accountNumber)) {
            System.out.println("số tài khoản đã tồn tại. không thể thêm mới");
            return;
        }

        // tìm nhân viên phụ trách
        Employee employee = findEmployeeId(employeeId);
        if(employee == null) {
            System.out.println("không tìm thấy nhân viên phù hợp. Tài khoản không được thêm");
            return;
        }

        // tạo tài khoản mới
        Account newAccount = new Account(accountNumber, accountHolder, balance, employee);
        accounts.put(accountNumber, newAccount);

        // liên kết tài khoản với nhân viên phụ trách
        employee.addAccount(newAccount);
        System.out.println("tài khoản mới đã được thêm thành công");
    }

    private Employee findEmployeeId(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getId().equals(employeeId)) {
                return emp;
            }
        }
        return null;
    }

    //sửa thông tin tài khoản
    public void updateAccount(String accountNumber, String newAccountHolder, double newBalance) {
        Account account = accounts.get(accountNumber);
        //kiểm tra xem tài khoản có tồn tại không
        if(account == null) {
            System.out.println("không tìm thấy tài khoản với số tài khoản " + accountNumber);
            return;
        }

        // cập nhật thông tin chủ tài khoản (accountHolder)
        if(newAccountHolder != null && !newAccountHolder.trim().isEmpty()) {
            account.setAccountHolder(newAccountHolder);
            System.out.println("tên chủ tài khoản đã được cập nhật thành " + newAccountHolder);
        } else {
            System.out.println("tên chủ tài khoản không hợp lệ");
        }

        // cập nhật số dư tài khoản (balance) nếu có
        if (newBalance >= 0) {
            account.setBalance(newBalance);
            System.out.println("số dư tài khoản đã được cập nhật thành " + newBalance);
        } else {
            System.out.println("số dư tài khoản không hợp lệ");
        }

    }

    //xóa tài khoản
    public void deleteAccount(String accountNumber) {
        // tìm tài khoản cần xóa
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("không tìm thấy tài khoản với số tài khoản " + accountNumber);
            return;
        }
        //kiểm tra số dư tài khoản
        if (account.getBalance() > 0) {
            System.out.println("không thể xóa tài khoản với số dư lớn hơn 0. vui lòng rút hết tiền trước");
            return;
        }
        // kiểm tra nếu tài khoản có giao dịch liên quan
        if(account.getTransactions() != null && !account.getTransactions().isEmpty()) {
            System.out.println("tài khoản có giao dịch liên quan, không thể xóa. Vui lòng xử lý giao dịch trước");
            return;
        }
        //xóa tài khoản khỏi danh sách quản lý
        accounts.remove(accountNumber);
        System.out.println("xóa tài khoản với số tài khoản " + accountNumber + " thành công");
    }

    //tìm kiếm tài khoản
    public Account searchAccount(String searchTerm) {
        // tìm kiếm theo số tài khoản
        Account accountByNumber = accounts.get(searchTerm);
        if (accountByNumber != null) {
            System.out.println("tài khoản tìm thấy: ");
            displayAccountsInfo(accountByNumber);
        }

        //tìm tên theo chủ tài khoản
        boolean found = false;
        for (Account account : accounts.values()) {
            if(account.getAccountHolder().equalsIgnoreCase(searchTerm)) {
                if(!found) {
                    System.out.println("tìm thấy các tài khoản có chủ sở hữu tên: " + searchTerm);
                }
                displayAccountsInfo(account);
            }
        }
        if(!found) {
            System.out.println("không tìm thấy tài khoản với thông tin đã nhập");
        }
        return accountByNumber;
    }

    // hiển thị thông tin tài khoản
    void displayAccountsInfo(Account account) {
        System.out.println("số tài khoản: " + account.getAccountNumber());
        System.out.println("tên chủ tài khoản: " + account.getAccountHolder());
        System.out.println("số dư: " + account.getBalance());
        System.out.println("nhân viên phụ trách: " + account.getEmployeeIncharge().getName());
        System.out.println("--------------------------------------------");
    }

    public Account findAccountByAccountNumber(String accountNumber) {
        for (Account account : accounts.values()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
