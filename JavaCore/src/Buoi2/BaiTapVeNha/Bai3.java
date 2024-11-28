package Buoi2.BaiTapVeNha;

import java.util.Scanner;

public class Bai3 {

    private void tinhTienDien(double soDien) {

        double tienDien;
        double tienBacMot = 1678;
        double tienBachai = 1734;
        double tienBacBa = 2014;
        double tienBacBon = 2536;
        double tienBacNam = 2834;
        double tienBacSau = 2927;
        double bacMot = 50;
        double bacHai = 100;
        double bacBa = 200;
        double bacBon = 300;
        double bacNam = 400;

        if (soDien <= bacMot) {
            tienDien = soDien * tienBacMot;
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (bacMot < soDien && soDien <= bacHai) {
            tienDien = (50 * tienBacMot) + ((soDien - 50) * tienBachai);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (bacHai < soDien && soDien <= bacBa) {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + ((soDien - 100) * tienBacBa);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (bacBa < soDien && soDien <= bacBon) {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + (100 * tienBacBa) + ((soDien - 200) * tienBacBon);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else if (bacBon < soDien && soDien <= bacNam) {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + (100 * tienBacBa) + (100 * tienBacBon) + ((soDien - 300) * tienBacNam);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        } else {
            tienDien = (50 * tienBacMot) + (50 * tienBachai) + (100 * tienBacBa) + (100 * tienBacBon) + (100 * tienBacNam) + ((soDien - 400) * tienBacSau);
            System.out.println("tien dien thang nay cua ban la: " + tienDien);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so dien: ");
        double soDien = scanner.nextDouble();
        Bai3 tinhSoTienDien = new Bai3();
        tinhSoTienDien.tinhTienDien(soDien);

    }
}
