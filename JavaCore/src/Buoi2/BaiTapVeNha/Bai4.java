package Buoi2.BaiTapVeNha;

import java.util.Scanner;

public class Bai4 {


    private void tinhDiemSinhVien() {

        System.out.println("<< CHUONG TRINH TINH DIEM SINH VIEN >>");
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap diem chuyen can: ");
        double diemChuyenCan = scanner.nextDouble();
        System.out.println("nhap diem giua ky: ");
        double diemGiuaKy = scanner.nextDouble();
        System.out.println("nhap diem cuoi ky: ");
        double diemCuoiKy = scanner.nextDouble();

        double diemTrungBinh = (diemChuyenCan + diemGiuaKy + diemCuoiKy) / 3;
        System.out.println("diem trung binh cua ban la:\t" + diemTrungBinh);

        if (diemTrungBinh >= 5 && diemTrungBinh < 7) {

            System.out.println("xep loai C");

        } else if (7 <= diemTrungBinh && diemTrungBinh < 9) {
            System.out.println("xep loai B");

        } else if (diemTrungBinh >= 9) {
            System.out.println("xep loai A");

        } else {
            System.out.println("xep loai D");

        }
    }

    private void kiemTraLoaiTamGiac() {

        System.out.println("<< CHUONG TRINH KIEM TRA LOAI TAM GIAC >>");
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap canh a");
        int a = scanner.nextInt();
        System.out.println("nhap canh b");
        int b = scanner.nextInt();
        System.out.println("nhap canh c");
        int c = scanner.nextInt();
        int x = a * a + b * b;
        int y = a * a + c * c;
        int z = b * b + c * c;


        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("khong phai hinh tam giac");

        } else {
            if (x == c * c || y == b * b || z == a * a) {
                System.out.println("day la tam giac vuong");
            } else if (a == b || a == c || b == c) {
                if (x == c * c || y == b * b || b * b + c * c == a * a) {
                    System.out.println("day la tam giac vuong can");
                } else {
                    System.out.println("day la tam giac can");
                }

            } else if (a == b && b == c) {
                System.out.println("day la tam giac deu");

            } else {
                System.out.println("day la tam giac thuong");
            }
        }
    }

    private void tinhTienDien() {

        System.out.println("<< CHUONG TRINH TINH TIEN DIEN >>");
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
            System.out.printf("tien dien thang nay cua ban la: %.2f", tienDien);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("+............................+");
        System.out.println("|  1.Tinh diem sinh vien     |");
        System.out.println("|  2.Kiem tra loai tam giac  |");
        System.out.println("|  3.Tinh tien dien          |");
        System.out.println("|  4.Ket thuc chuong trinh   |");
        System.out.println("+............................+");
        System.out.println(" <<MOI BAN CHON CHUC NANG >>");
        int a = scanner.nextInt();

        switch (a) {
            case 1:
                Bai4 TinhDiem = new Bai4();
                TinhDiem.tinhDiemSinhVien();
                break;
            case 2:
                Bai4 KiemTra = new Bai4();
                KiemTra.kiemTraLoaiTamGiac();
                break;
            case 3:
                Bai4 TinhTienDien = new Bai4();
                TinhTienDien.tinhTienDien();
                break;
            default:
                System.out.println("ban da thoat truong chinh");
                System.exit(0);
        }


    }
}
