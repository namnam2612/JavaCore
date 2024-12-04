package Buoi4.BTVN;

import java.util.Arrays;
import java.util.Scanner;

public class Bai3V2 {

    public static int soLuongPhanTu = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap vao do dai cua mang: ");
        int n = sc.nextInt();
        int[] mangDoNguoiDungNhap = nhapMang(n, sc);

        hienThi(mangDoNguoiDungNhap);
        tinhTongPhanTuChanLe(mangDoNguoiDungNhap);
        soNguyenTo(mangDoNguoiDungNhap);


        sapxep(mangDoNguoiDungNhap);

    }

    private static void sapxep(int[] mangDoNguoiDungNhap) {
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] % 2 == 0) {
                for (int j = i + 1; j < mangDoNguoiDungNhap.length; j++) {
                    if (mangDoNguoiDungNhap[i] % 2 == 0 || mangDoNguoiDungNhap[i] > mangDoNguoiDungNhap[j]) {
                        continue;
                    }
                    int tam = mangDoNguoiDungNhap[i];
                    mangDoNguoiDungNhap[i] = mangDoNguoiDungNhap[j];
                    mangDoNguoiDungNhap[j] = tam; // dang lam gio mai lam tiep ahihi
                }


            }

        }

        System.out.print("\nso chan giam dan la: " + Arrays.toString(mangDoNguoiDungNhap));
    }

    private static void soNguyenTo(int[] mangDoNguoiDungNhap) {
        System.out.println("cac so nguyen to la");
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (!checkSoNguyenTo(mangDoNguoiDungNhap[i])) {
                continue;
            }
            System.out.print(mangDoNguoiDungNhap[i] + " ");

        }
    }

    private static boolean checkSoNguyenTo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    private static void tinhTongPhanTuChanLe(int[] mangDoNguoiDungNhap) {
        int tongLe = 0;
        int tongChan = 0;

        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] % 2 == 0) {
                tongChan += mangDoNguoiDungNhap[i];
            } else {
                tongLe += mangDoNguoiDungNhap[i];
            }

        }
        System.out.println("\n" + "tong cac phan tu le la: " + tongLe);
        System.out.println("tong cac phan tu le la: " + tongChan);
    }

    private static void hienThi(int[] mangDoNguoiDungNhap) {
        System.out.println("mang do nguoi dung nhap vao la: ");
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            System.out.print(mangDoNguoiDungNhap[i] + "\t");

        }
    }

    private static int[] nhapMang(int n, Scanner sc) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("nhap vao phan tu cua mang" + (i + 1));
            array[i] = sc.nextInt();
            soLuongPhanTu++;

        }
        return array;
    }
}
