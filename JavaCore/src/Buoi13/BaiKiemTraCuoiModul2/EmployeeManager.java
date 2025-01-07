package Buoi13.BaiKiemTraCuoiModul2;


import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;
    private List<Account> accounts = new ArrayList<>();

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    //thêm nhân viên mới
    public void addEmployee(String id, String name, double salary) {
        //kiểm tra id đã tồn tại chưa
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                System.out.println("id nhân viên đã tồn tại");
                return;
            }
        }
        Employee newEmployee = new Employee(id,name,salary, new ArrayList<>());
        employees.add(newEmployee);
        System.out.println("nhân viên mới đã được thêm: " + newEmployee.getName());
    }
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("không có nhân viên trong hệ thống");
        } else {
            employees.sort((e1, e2) -> e1.getId().compareTo(e2.getId())); // sắp xếp nhân viên theo id hoặc tên
            System.out.println("danh sách nhân viên: ");
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId() +
                        ", Tên: " + employee.getName() +
                        ", Lương: " + employee.getSalary() +
                        ", Tài khoản quản lý: " + employee.getManagedAccounts().size());
            }
        }
    }

    public void assignAccountToEmployee(String employeeId, String accountNumber) {
        Employee employee = null;
        Account account = null;
        for (Employee e : employees) {
            if (e.getId().equals(employeeId)) {
                employee = e;
                break;
            }
        } if (employee == null) {
            System.out.println("nhân viên không tồn tại");
            return;
        }
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) {
                account = a;
                break;
            }
        } if (account == null) {
            System.out.println("tài khoản không tồn tại");
            return;
        } if (account.getEmployeeIncharge() != null) {
            System.out.println("tài khoản này đã được gán cho nhân viên khác");
            return;
        }
        employee.addAccount(account);
        account.setEmployeeIncharge(employee);
        System.out.println("Tài khoản " + accountNumber + " đã được gán cho nhân viên " + employeeId + ".");
    }

    //thêm tài khoản vào danh sách account
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
}
