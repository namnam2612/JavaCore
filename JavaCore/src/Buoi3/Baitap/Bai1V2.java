package Buoi3.Baitap;

import java.util.Scanner;
    /*
    Tính S(n) = 1^3 + 2^3 + 3^3 + .... +  n^3 n nhập từ bàn phím
    nhập n từ bàn phím (n dương, nếu n âm bắt nhập lại) và in ra màn hình dãy S(n)
    */
public class Bai1V2 {
    private int getN() {
        Scanner sc = new Scanner(System.in);

        int n = 0;

        do {
            System.out.println("nhap so n: ");
            n = sc.nextInt();
        } while (n < 0);
        return n;

    }

    public static void main(String[] args) {
        System.out.println(">>Chuong trinh tinh S(n) = 1^3 + 2^3 + 3^3 + .... +  n^3");
        Bai1V2 nhapN = new Bai1V2();
        int n = nhapN.getN();
        long tong = 0;


        for (int i = 0; i <= n; i++) {
            tong += Math.pow(i,3);

        }

        System.out.println("Tong cua S(n) = 1^3 + 2^3 + 3^3 + .... +  n^3 = " + tong);
    }
}
