package Buoi4.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * cho người dùng nhập vao n số tự nhiên
 * + n do người dùng nhập
 * +sau đó cho phép người dùng nhập vào n số tự nhiên
 * yêu cầu:
 * 1) hiển thị các số người dùng nhập vào
 * 2) tính tổng các chữ số trong mảng
 * 3) tìm số lớn nhất và nhỏ nhất trong mảng
 * 4) sắp xếp các phần tử theo thứ tự từ nhỏ đến lớn
 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap vao n: ");
        int n = sc.nextInt();

        int[] mangDoNguoiDungNhap = nguoiDungNhapTuBanPhim(n, sc);

        duLieuNguoiDungNhap(mangDoNguoiDungNhap);
        tongCacSoNguoiDungNhap(mangDoNguoiDungNhap);
        timMinMax(mangDoNguoiDungNhap);
        sapXep(mangDoNguoiDungNhap);

    }

    private static void sapXep(int[] mangDoNguoiDungNhap) {


        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            for (int j = i + 1; j < mangDoNguoiDungNhap.length; j++) {
                if (mangDoNguoiDungNhap[i] > mangDoNguoiDungNhap[j]) {
                    int tam = mangDoNguoiDungNhap[i];
                    mangDoNguoiDungNhap[i] = mangDoNguoiDungNhap[j];
                    mangDoNguoiDungNhap[j] = tam;
                }
            }
        }
        System.out.println("mang sap xep tu be den lon la: " + Arrays.toString(mangDoNguoiDungNhap));
    }
    private static void timMinMax(int[] mangDoNguoiDungNhap) {
        int max = mangDoNguoiDungNhap[0];
        int min = mangDoNguoiDungNhap[0];
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] > max) {
                max = mangDoNguoiDungNhap[i];
            }
            if (mangDoNguoiDungNhap[i] < min) {
                min = mangDoNguoiDungNhap[i];
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    private static int[] nguoiDungNhapTuBanPhim(int n, Scanner sc) {
        int[] mangDoNguoiDungNhap = new int[n];
        int duLieuMang = 0;


        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            System.out.println("nhap vao phan tu co index: " + (i + 1));
            duLieuMang = sc.nextInt(); //nhập dữ liệu
            mangDoNguoiDungNhap[i] = duLieuMang; // gán dữ liệu vào mảng
        }
        return mangDoNguoiDungNhap;
    }

    private static void duLieuNguoiDungNhap(int[] mangDoNguoiDungNhap) {
        System.out.println("cac so nguoi dung nhap vao la: ");
        for (int j = 0; j < mangDoNguoiDungNhap.length; j++) {

            int soNguoiDungNhapVaoMang = mangDoNguoiDungNhap[j];
            System.out.printf(soNguoiDungNhapVaoMang + "\t");
        }
    }

    private static void tongCacSoNguoiDungNhap(int[] mangDoNguoiDungNhap) {
        int tong = 0;
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {

            tong += mangDoNguoiDungNhap[i];

        }
        System.out.println("\ntong cac so trong mang la: " + tong);
    }
}
