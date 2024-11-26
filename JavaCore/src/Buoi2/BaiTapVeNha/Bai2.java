package Buoi2.BaiTapVeNha;
/*Bài 2


Nhập vào chương trình 2 số nguyên dương a,b,c
In ra màn hình kết luận về tam giác có 3 cạnh trên (tam giác thường,
tam giác vuông, tam giác cân, tam giác vuông cân, tam giác đều hoặc không phải tam giác)


*/

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap canh a");
        int a = scanner.nextInt();
        System.out.println("nhap canh b");
        int b = scanner.nextInt();
        System.out.println("nhap canh c");
        int c = scanner.nextInt();


        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("khong phai hinh tam giac");

        } else {
            if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("day la tam giac vuong");
            } else if (a == b || a == c || b == c) {
                if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                    System.out.println("day la tam giac vuong can");
                } else {
                    System.out.println("day la tam giac can");
                }

            } else if (a == b && a == c) {
                System.out.println("day la tam giac deu");

            } else {
                System.out.println("day la tam giac thuong");
            }
        }
    }
}
