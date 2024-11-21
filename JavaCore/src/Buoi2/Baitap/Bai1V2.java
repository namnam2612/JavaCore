package Buoi2.Baitap;

import java.util.Scanner;

public class Bai1V2 {
    public static void main(String[] args) {
        double luongTheoGio = 50000;
        double soGioTieuChuan = 40;
        double heSo = 1.5;
        double tienLuong;
        System.out.println("nhap so gio lam:");

        double gioLamViec = new Scanner(System.in).nextDouble();

        if(gioLamViec > soGioTieuChuan) {
            tienLuong = (gioLamViec - soGioTieuChuan) * (luongTheoGio * heSo) + gioLamViec * luongTheoGio;
            System.out.printf("tien luong nhan duoc la:\t" + tienLuong);

        } else {
            tienLuong = gioLamViec * luongTheoGio;
            System.out.printf("tien luong nhan duoc la:\t" + tienLuong);

        }
    }
}
