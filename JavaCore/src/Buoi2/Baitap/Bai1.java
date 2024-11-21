package Buoi2.Baitap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("so gio lam viec nhan vien da lam: \t");
        double gioLamViec = scanner.nextDouble();

        if(gioLamViec > 40) {
            double tienLuong = (gioLamViec - 40) * 50000 * 1.5 + 40 * 50000;
            System.out.println("tien luong nhan duoc la:\t" + tienLuong);
        }
        else {
            double tienLuong = gioLamViec * 50000 ;
            System.out.println("tien luong nhan duoc la:\t" + tienLuong);
        }
    }
}
