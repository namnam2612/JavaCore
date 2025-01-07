package Buoi13.BaiKiemTraCuoiModul2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static EmployeeManager employeeManager = new EmployeeManager();
    private static TransactionManager transactionManager;
    private static AccountManager accountManager;
    private static bankingSystem bankingSystem;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Khởi tạo hệ thống
        bankingSystem = new bankingSystem();
        accountManager = new AccountManager(new ArrayList<>());
        transactionManager = new TransactionManager(bankingSystem.getAccounts());

        // Menu chương trình
        while (true) {
            showMenu();
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng rỗng sau khi nhập số

            switch (choice) {
                case 1:
                    manageAccount(scanner);
                    break;
                case 2:
                    handleTransaction(scanner);
                    break;
                case 3:
                    manageTransactions(scanner);
                    break;
                case 4:
                    manageEmployees(scanner);
                    break;
                case 5:
                    System.out.println("Thoát khỏi hệ thống.");
                    return;
                default:
                    System.out.println("Chọn chức năng không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n================== DANH SÁCH CHỨC NĂNG ==================");
        System.out.println("1. Quản lý tài khoản:");
        System.out.println("  1.1. Thêm tài khoản mới.");
        System.out.println("  1.2. Sửa thông tin tài khoản.");
        System.out.println("  1.3. Xóa tài khoản.");
        System.out.println("  1.4. Tìm kiếm tài khoản.");
        System.out.println("2. Giao dịch tài khoản:");
        System.out.println("  2.1. Nạp tiền vào tài khoản.");
        System.out.println("  2.2. Rút tiền từ tài khoản.");
        System.out.println("  2.3. Chuyển khoản giữa hai tài khoản.");
        System.out.println("3. Quản lý giao dịch:");
        System.out.println("  3.1. Hiển thị lịch sử giao dịch của một tài khoản.");
        System.out.println("  3.2. Hiển thị toàn bộ giao dịch trong hệ thống.");
        System.out.println("4. Quản lý nhân viên:");
        System.out.println("  4.1. Thêm nhân viên mới.");
        System.out.println("  4.2. Xem danh sách nhân viên.");
        System.out.println("  4.3. Gán tài khoản cho nhân viên.");
        System.out.println("5. Thoát chương trình.");
        System.out.println("==========================================================");
    }

    private static void manageAccount(Scanner scanner) {
        System.out.println("\nQuản lý tài khoản:");
        System.out.println("1.1. Thêm tài khoản mới.");
        System.out.println("1.2. Sửa thông tin tài khoản.");
        System.out.println("1.3. Xóa tài khoản.");
        System.out.println("1.4. Tìm kiếm tài khoản.");
        System.out.print("Chọn chức năng: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Đọc dòng rỗng

        switch (choice) {
            case 1:
                addAccount(scanner);
                break;
            case 2:
                updateAccount(scanner);
                break;
            case 3:
                deleteAccount(scanner);
                break;
            case 4:
                searchAccount(scanner);
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }

    private static void addAccount(Scanner scanner) {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập tên chủ tài khoản: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Nhập số dư tài khoản: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();  // Đọc dòng rỗng
        System.out.print("Nhập ID nhân viên phụ trách: ");
        String employeeId = scanner.nextLine();

        accountManager.addAccount(accountNumber, accountHolder, balance, employeeId);
    }

    private static void updateAccount(Scanner scanner) {
        System.out.print("Nhập số tài khoản cần sửa: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập tên chủ tài khoản mới: ");
        String newAccountHolder = scanner.nextLine();
        System.out.print("Nhập số dư tài khoản mới: ");
        double newBalance = scanner.nextDouble();
        scanner.nextLine();  // Đọc dòng rỗng

        accountManager.updateAccount(accountNumber, newAccountHolder, newBalance);
    }

    private static void deleteAccount(Scanner scanner) {
        System.out.print("Nhập số tài khoản cần xóa: ");
        String accountNumber = scanner.nextLine();
        accountManager.deleteAccount(accountNumber);
    }

    private static void searchAccount(Scanner scanner) {
        System.out.print("Nhập số tài khoản hoặc tên chủ tài khoản cần tìm: ");
        String searchTerm = scanner.nextLine();

        Account account = accountManager.searchAccount(searchTerm);
        if (account != null) {
            accountManager.displayAccountsInfo(account);
        } else {
            System.out.println("Không tìm thấy tài khoản.");
        }
    }

    private static void handleTransaction(Scanner scanner) {
        System.out.println("\nGiao dịch tài khoản:");
        System.out.println("2.1. Nạp tiền vào tài khoản.");
        System.out.println("2.2. Rút tiền từ tài khoản.");
        System.out.println("2.3. Chuyển khoản giữa hai tài khoản.");
        System.out.print("Chọn chức năng: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Đọc dòng rỗng

        switch (choice) {
            case 1:
                depositToAccount(scanner);
                break;
            case 2:
                withdrawFromAccount(scanner);
                break;
            case 3:
                transferMoney(scanner);
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }

    private static void depositToAccount(Scanner scanner) {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập số tiền nạp: ");
        double amount = scanner.nextDouble();

        bankingSystem.depositToAccount(accountNumber, amount);
    }

    private static void withdrawFromAccount(Scanner scanner) {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập số tiền rút: ");
        double amount = scanner.nextDouble();

        bankingSystem.withdrawFromAccount(accountNumber, amount);
    }

    private static void transferMoney(Scanner scanner) {
        System.out.print("Nhập số tài khoản gửi: ");
        String fromAccountNumber = scanner.nextLine();
        System.out.print("Nhập số tài khoản nhận: ");
        String toAccountNumber = scanner.nextLine();
        System.out.print("Nhập số tiền chuyển: ");
        double amount = scanner.nextDouble();

        bankingSystem.transferMoney(fromAccountNumber, toAccountNumber, amount);
    }

    private static void manageTransactions(Scanner scanner) {
        System.out.println("\nQuản lý giao dịch:");
        System.out.println("3.1. Hiển thị lịch sử giao dịch của một tài khoản.");
        System.out.println("3.2. Hiển thị toàn bộ giao dịch trong hệ thống.");
        System.out.print("Chọn chức năng: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Đọc dòng rỗng

        switch (choice) {
            case 1:
                displayTransactionHistory(scanner);
                break;
            case 2:
                displayAllTransactionHistory();
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }

    private static void displayTransactionHistory(Scanner scanner) {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        transactionManager.displayTransactionHistory(accountNumber);
    }

    private static void displayAllTransactionHistory() {
        transactionManager.displayAllTransactionHistory();
    }

    private static void manageEmployees(Scanner scanner) {
        System.out.println("\nQuản lý nhân viên:");
        System.out.println("4.1. Thêm nhân viên mới.");
        System.out.println("4.2. Xem danh sách nhân viên.");
        System.out.println("4.3. Gán tài khoản cho nhân viên.");
        System.out.print("Chọn chức năng: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Đọc dòng rỗng

        switch (choice) {
            case 1:
                addEmployee(scanner);
                break;
            case 2:
                displayAllEmployees();
                break;
            case 3:
                assignAccountToEmployee(scanner);
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Nhập ID nhân viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập lương cơ bản của nhân viên: ");
        double salary = scanner.nextDouble();

        employeeManager.addEmployee(id, name, salary);
    }

    private static void displayAllEmployees() {
        employeeManager.displayAllEmployees();
    }

    private static void assignAccountToEmployee(Scanner scanner) {
        System.out.print("Nhập ID nhân viên: ");
        String employeeId = scanner.nextLine();
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();

        employeeManager.assignAccountToEmployee(employeeId, accountNumber);
    }
}
