package Buoi2.Baitap;

import java.util.Scanner;

public class Bai3 {
    public static void giaiPhuongTrinhBacNhat(double b, double c) {
        if (b == 0 && c == 0) {
            System.out.println("phuong trinh bx + c = 0 co vo so nghiem ");

        } else if (b == 0 && c != 0) {
            System.out.println("phuong trinh vo nghiem");
        } else {
            System.out.println("phuong trinh bx + c = 0 co nghiem duy nhat la x = -c/b = " + (-c / b));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.printf("nhap so a:\t");
        double a = scanner.nextDouble();
        System.out.printf("nhap so b:\t");
        double b = scanner.nextDouble();
        System.out.printf("nhap so c:\t");
        double c = scanner.nextDouble();


        if (a == 0) {
            giaiPhuongTrinhBacNhat(b, c);
        } else {
            double delta = (Math.pow(b, 2) - (4 * a * c));
            if (delta < 0) {
                System.out.println("phuong trinh vo nghiem");
            } else if (delta == 0) {
                System.out.println("phuong trinh co nghiem kep x = " + (-b / (2 * a)));
            } else {
                System.out.println("phuong trinh co 2 nghiem phan biet: \n" + "x1 =\t" + (float) ((-b + (Math.sqrt(delta))) / 2 * a) + "\n" + "x2 =\t" + (float) ((-b - (Math.sqrt(delta))) / 2 * a));
            }

        }


    }
}
