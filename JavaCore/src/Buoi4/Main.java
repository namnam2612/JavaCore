package Buoi4;

import java.util.Scanner;

/*
    Mảng:
    +

*/
public class Main {
    public static void main(String[] args) {

        int[] mangCacSoNguyen = new int[10];
        String mangCacKyTu[] = new String[10];
        double[] mangCacSoTuNhien = {1.2, 1.3, 1.4};

        System.out.println("do dai cua mang " + mangCacKyTu.length);  // lay ra do dai cua mang
        //them cac ky tu vao index
        mangCacKyTu[0] = "A";
        mangCacKyTu[1] = "B";
        mangCacKyTu[2] = "C";


        //lay ra phan tu cua index 1 va 3
        System.out.println("lay ra cac ky tu " + mangCacKyTu[0]);
        System.out.println("lay ra cac ky tu " + mangCacKyTu[2]);

        //duyệt tất cả các phần tử của mảng

        for (int index = 0; index < mangCacKyTu.length; index++) {
            String duLieuMang = mangCacKyTu[index];
            System.out.println(" " + duLieuMang);
        }
        Scanner sc = new Scanner(System.in);
        String duLieuMang = "";
        // nhập vào các số trong mảng
        for (int i = 0; i < mangCacKyTu.length; i++) {
            //thu thập dữ liệu người dùng nhập
            System.out.println("nhap vao cac phan tu co index: " + i);
            duLieuMang = sc.nextLine();

        }


    }
}
