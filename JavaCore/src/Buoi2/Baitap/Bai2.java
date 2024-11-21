package Buoi2.Baitap;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("nhap so a: ");
        float a = scanner.nextFloat();
        System.out.println("nhap so b: ");
        float b = scanner.nextFloat();

        if (a == 0 && b == 0) {
            System.out.println("phuong trinh ax + b = 0 co vo so nghiem ");

        } else if (a == 0 && b != 0) {
            System.out.println("phuong trinh vo nghiem");
        } else {
            float c = (float) (-b / a);
            System.out.println("phuong trinh ax + b = 0 co nghiem duy nhat la x = -b/a = " + c);
        }

    }
}

