package buoi1;

import java.util.Scanner;

public class Bai3 {
    public static void  main (String[] args) {
        System.out.println("nhap chieu dai hinh chu nhat : ");
        Integer chieudai = new Scanner(System.in).nextInt();

        System.out.println("nhap chieu rong hinh chu nhat : ");
        Integer chieurong = new Scanner(System.in).nextInt();

        System.out.println("dien tich hinh chu nhat = " + (chieudai * chieurong));
    }
}
