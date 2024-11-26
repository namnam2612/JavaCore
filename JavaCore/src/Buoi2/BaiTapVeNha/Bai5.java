package Buoi2.BaiTapVeNha;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap nam: ");
        int a = scanner.nextInt();
        System.out.println("Moi ban nhap thang can tim so ngay:");
        int b = scanner.nextInt();
        int thuongCuaNamChiaBon = a % 4;
        int thuongCuaNamChiaMotTram = a % 100;
        int thuongCuaNamChiaBonTram = a % 400;

        if (thuongCuaNamChiaBon == 0 && thuongCuaNamChiaMotTram != 0 || thuongCuaNamChiaBonTram == 0) {
            System.out.println("Day la nam nhuan");
            switch (b) {
                case 1:
                    System.out.println("thang 1 co` 31` ngay");
                    break;
                case 2:
                    System.out.println("thang 2 co 29 ngay");
                    break;
                case 3:
                    System.out.println("thang 3 co 31 ngay");
                    break;
                case 4:
                    System.out.println("thang 4 co 30 ngay");
                    break;
                case 5:
                    System.out.println("thang 5 co 31 ngay");
                    break;
                case 6:
                    System.out.println("thang 6 co 30 ngay");
                    break;
                case 7:
                    System.out.println("thang 7 co 31 ngay");
                    break;
                case 8:
                    System.out.println("thang 8 co 31 ngay");
                    break;
                case 9:
                    System.out.println("thang 9 co 30 ngay");
                    break;
                case 10:
                    System.out.println("thang 10 co 31 ngay");
                    break;
                case 11:
                    System.out.println("thang 11 co 30 ngay");
                    break;
                case 12:
                    System.out.println("thang 12 co 31 ngay");
                    break;
            }

        } else {
            System.out.println("Day la nam khong nhuan");
            switch (b) {
                case 1:
                    System.out.println("thang 1 co 31 ngay");
                    break;
                case 2:
                    System.out.println("thang 2 co 28 ngay");
                    break;
                case 3:
                    System.out.println("thang 3 co 31 ngay");
                    break;
                case 4:
                    System.out.println("thang 4 co 30 ngay");
                    break;
                case 5:
                    System.out.println("thang 5 co 31 ngay");
                    break;
                case 6:
                    System.out.println("thang 6 co 30 ngay");
                    break;
                case 7:
                    System.out.println("thang 7 co 31 ngay");
                    break;
                case 8:
                    System.out.println("thang 8 co 31 ngay");
                    break;
                case 9:
                    System.out.println("thang 9 co 30 ngay");
                    break;
                case 10:
                    System.out.println("thang 10 co 31 ngay");
                    break;
                case 11:
                    System.out.println("thang 11 co 30 ngay");
                    break;
                case 12:
                    System.out.println("thang 12 co 31 ngay");
                    break;
            }
        }
    }
}
