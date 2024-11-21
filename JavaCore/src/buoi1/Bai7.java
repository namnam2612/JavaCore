package buoi1;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        System.out.println("nhap ten sinh vien: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("nhap diem sinh vien");
        int score = new Scanner(System.in).nextInt();

        System.out.println("Sinh vien " + name + " co diem la " + score);

    }
}
