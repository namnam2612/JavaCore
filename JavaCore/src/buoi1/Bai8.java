package buoi1;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        System.out.println("nhap chieu dai hinh chu nhat: ");
        double chieu_dai = new Scanner(System.in).nextDouble();

        System.out.println("nhap chieu rong hinh chu nhat: ");
        double chieu_rong = new Scanner(System.in).nextDouble();

        System.out.print("chu vi = " + ( (chieu_dai + chieu_rong) *2) +"\n"+ "dien tich = " + ( chieu_dai * chieu_rong ) + "\n" + "canh nho nhat = " + ( Math.min(chieu_dai,chieu_rong) ) );
    }
    
}
