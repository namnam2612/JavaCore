package buoi1;

import java.util.Scanner;

//bai 1
public class Bai1 {
    public static void main(String[] args) {
//test thu cai
        System.out.println("nhap vao ho va ten cua hoc vien: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("nhap vao ngay thang nam sinh cua hoc vien: ");
        int age = new Scanner(System.in).nextInt();


        System.out.println("nhap vao que quan cua hoc vien: ");
        String address = new Scanner(System.in).nextLine();

        System.out.println("nhap vao truong hoc cua hoc vien: ");
        String school = new Scanner(System.in).nextLine();

        System.out.println("xin chao " + name + " den tu " + address + ", sinh ngay " + age + ", hoc tai truong " + school);

    }
}

