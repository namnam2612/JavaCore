package Buoi6.BTVN.Bai2AndBai3;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        manageBankAccountInformation[] account = ganIdVaoMang();
        xuLy(account);
    }

    private static void xuLy(manageBankAccountInformation[] account) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("nhập id tài khoản: ");
            n = sc.nextInt();
        } while (n < 0 || n > 9);

        manageBankAccountInformation currentAccount = account[n];
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1: Xem số dư");
            System.out.println("2: Rút tiền");
            System.out.println("3: Gửi tiền");
            System.out.println("4: Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hienThiSoDu(currentAccount);
                    break;
                case 2:
                    rutTien(sc, currentAccount);
                    break;
                case 3:
                    guiTien(sc, currentAccount);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ");
            }
        }
    }

    private static void hienThiSoDu(manageBankAccountInformation currentAccount) {
        System.out.println("Số dư hiện tại: " + currentAccount.getBalance());
    }

    private static void guiTien(Scanner sc, manageBankAccountInformation currentAccount) {
        System.out.println("nhập số tiền gửi");
        double sotienGui = sc.nextDouble();
        if (sotienGui <= 0) {
            System.out.println("số tiền gửi không được nhỏ hơn 0");
        } else {
            currentAccount.deposit(sotienGui);
            System.out.println("số dư " + currentAccount.getBalance());
        }
    }

    private static void rutTien(Scanner sc, manageBankAccountInformation currentAccount) {
        System.out.println("Số tiền rút là");
        double soTienRut = sc.nextDouble();
        if (soTienRut <= 0) {
            System.out.println("số tiền rút phải lớn hơn 0");
        } else if (soTienRut > currentAccount.getBalance()) {
            System.out.println("không đủ số dư");
        } else {
            currentAccount.withdraw(soTienRut);
            System.out.println("rút tiền thành công, số dư mới là " + currentAccount.getBalance());
        }
    }

    private static manageBankAccountInformation[] ganIdVaoMang() {
        manageBankAccountInformation[] account = new manageBankAccountInformation[10];
        for (int i = 0; i < account.length; i++) {
            account[i] = new manageBankAccountInformation();
            account[i].setId(i);
            account[i].setBalance(100);
            account[i].setAnnuallnterestRate(0.0);
        }
        return account;
    }
}

