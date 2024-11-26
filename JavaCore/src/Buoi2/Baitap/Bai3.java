package Buoi2.Baitap;

import java.util.Scanner;

public class Bai3 {
    private void giaiPhuongTrinhBacNhat(double b, double c) {
        if (b == 0 && c == 0) {
            System.out.printf("phuong trinh %.0fx + %.0f = 0 co vo so nghiem ", b, c);

        } else if (b == 0) {
            System.out.printf("phuong trinh %.0fx + %.0f = 0 vo nghiem ", b, c);
        } else {
            double n = -c / b;
            System.out.printf("phuong trinh %.0fx + %.0f = 0 co nghiem duy nhat la x = %.0f", b, c, n);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("nhap so a:\t");
        double a = scanner.nextDouble();
        System.out.println("nhap so b:\t");
        double b = scanner.nextDouble();
        System.out.println("nhap so c:\t");
        double c = scanner.nextDouble();


        if (a == 0) {
            Bai3 giaiPhuongTrinhBacNhat = new Bai3();
            giaiPhuongTrinhBacNhat.giaiPhuongTrinhBacNhat(b, c);
        } else {
            double delta = (Math.pow(b, 2) - (4 * a * c));
            if (delta < 0) {
                System.out.printf("Phuong trinh %.0fx^2 %.0fx + %.0f = 0 vo nghiem ", a, b, c);
            } else if (delta == 0) {
                double x = (-b / (2 * a));
                System.out.printf("phuong trinh %.0fx^2 %.0fx + %.0f = 0 co nghiem kep x = %.2f", a, b, c, x);
            } else {
                double x1 = (-b + (Math.sqrt(delta))) / (2 * a);
                double x2 = (-b - (Math.sqrt(delta))) / (2 * a);
                System.out.printf("Phuong trinh %.0fx^2 %.0fx + %.0f = 0 co hai nghiem phan biet: x1 = %.2f \t x2 = %.2f", a, b, c, x1, x2);
            }
        }
    }
}
