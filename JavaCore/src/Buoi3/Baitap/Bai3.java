package Buoi3.Baitap;

import java.util.Scanner;

public class Bai3 {
    /*
    de quy: nhap vao n, tinh giai thua cua n
    n! = n * (n-1) * (n-2) * ... * 1
    */

    private int tinhGiaiThua(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * tinhGiaiThua(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("tinh giai thua n! = n * (n-1) * (n-2) * ... * 1: ");
        System.out.println("moi ban nhap so n: ");

        int n = sc.nextInt();

        Bai3 ketQua = new Bai3();
        int dapAn = ketQua.tinhGiaiThua(n);

        System.out.println("ket qua la: " + dapAn);
    }
}
