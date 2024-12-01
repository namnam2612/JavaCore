package Buoi4.BTVN;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap vao mot chuoi String: ");

        String chuoi = sc.nextLine();
        if (kiemTraSoDienThoai(chuoi)) {
            System.out.println("Số điện thoại hợp lệ.");
        } else {
            System.out.println("Số điện thoại không hợp lệ.");
        }

        sc.close();


    }

    private static boolean kiemTraSoDienThoai(String sdt) {
        String sdtDaXuLy = sdt.replaceAll("[^0-9]", "");

        if (sdtDaXuLy.startsWith("84") && sdtDaXuLy.length() == 11) {
            return true;

        } else if (sdtDaXuLy.startsWith("0") && sdtDaXuLy.length() == 10) {
            return true;

        } else if (sdtDaXuLy.length() == 9) {
            return true;

        }
        return false;
    }
}
