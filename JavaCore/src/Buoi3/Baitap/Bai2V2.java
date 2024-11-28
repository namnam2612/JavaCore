package Buoi3.Baitap;

import java.util.Scanner;

/*
  Viet lai chu so dao nguoc
  vi du  nhap vao so 1357 thi in ra so dao nguoc la 7531
  (khong su dungj nhap vao chuoi so la string)
  */
public class Bai2V2 {
    private int soDaoNguoc(int n) {
        int soDao = 0;

        while (n != 0) {
            int soCuoi = n % 10;
            soDao = soDao * 10 + soCuoi;
            n = n / 10;
        }

        return soDao;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhao so n: ");

        int n = sc.nextInt();

        Bai2V2 nhapN = new Bai2V2();
        int ketQua = nhapN.soDaoNguoc(n);

        System.out.println("so dao la: " + ketQua);
    }

}
