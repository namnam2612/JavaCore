package Buoi2.BaiTapVeNha;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so dien: ");
        double soDien = scanner.nextDouble();
        double tienDien;

        double tienBacMot = 1678;
        double tienBachai = 1734;
        double tienBacBa = 2014;
        double tienBacBon = 2536;
        double tienBacNam = 2834;
        double tienBacSau = 2927;

        if (soDien <= 50) {
            tienDien = soDien * tienBacMot;
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (50 < soDien && soDien <= 100) {
            tienDien = (50 * tienBacMot) + ((soDien - 50) * tienBachai);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (100 < soDien && soDien <= 200) {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + ((soDien - 100) * tienBacBa);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (200 < soDien && soDien <= 300) {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + (100 * tienBacBa) + ((soDien - 200) * tienBacBon);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (300 < soDien && soDien <= 400) {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + (100 * tienBacBa) + (100 * tienBacBon) + ((soDien - 300) * tienBacNam);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + (100 * tienBacBa) + (100 * tienBacBon) + (100 * tienBacNam) + ((soDien - 400) * tienBacSau);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        }
    }
}
