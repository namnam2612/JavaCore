package Buoi3.Baitap;

import java.util.Scanner;

public class Bai1 {
    /*
    Tính S(n) = 1^3 + 2^3 + 3^3 + .... +  n^3 n nhập từ bàn phím
    nhập n từ bàn phím (n dương, nếu n âm bắt nhập lại) và in ra màn hình dãy S(n)
    */
    public static int getN() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(">>Chuong trinh tinh S(n) = 1^3 + 2^3 + 3^3 + .... +  n^3");
        int n = 0;

        do {
            System.out.println("Moi ban nhap n:");

            n = scanner.nextInt();

        } while (n <= 0);
        return n;

    }

    public static void main(String[] args) {
        int n = getN();
        long tong = 0;
        for (int i = 0; i <= n; i++) {
            tong += (long) Math.pow(i, 3);
        }

        System.out.println("Tong S(n) = 1^3 + 2^3 + 3^3 + .... +  n^3 la: " + tong);
    }
}
