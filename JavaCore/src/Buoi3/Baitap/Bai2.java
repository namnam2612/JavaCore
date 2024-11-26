package Buoi3.Baitap;

import java.util.Scanner;

public class Bai2 {
    /*
    Viet lai chu so dao nguoc
    vi du  nhap vao so 1357 thi in ra so dao nguoc la 7531
    (khong su dungj nhap vao chuoi so la string)
    */


    public static void main(String[] args) {
        System.out.println("nhap so n: ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ketQuaBai2 = bai2(n);
        System.out.println("so dao nguoc cua no la: " + ketQuaBai2);


    }

    public static int bai2(int n) {

        int soDaoNguoc = 0;

        while (n != 0) {
            int soDuoi = n % 10;
            soDaoNguoc = soDaoNguoc * 10 + soDuoi;
            n = n / 10;
        }

        return soDaoNguoc;
    }


}


