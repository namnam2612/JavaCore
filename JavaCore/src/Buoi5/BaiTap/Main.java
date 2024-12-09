package Buoi5.BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // new yêu cầu heap cấp phát ô nhớ để lưu trữ đối tượng animal được tham chiếu
        //từ biến conMeo tại stack
        // new Animal() constructor sử dụng đ khởi tạo đối tượng animal

        Animal conMeo = new Animal();

        // sử dụng dấu chấm ( . ) để truy cập vào các method
        conMeo.setTen("con cho");
        conMeo.setGioiTinh("nu");
        conMeo.setMauLong("mau den trang");
        conMeo.setSoChan(3);
        conMeo.setTuoi(2);

        conMeo.an();
        conMeo.diLai();

        // tạo ra một con voi

        Animal conVoi = new Animal();
        conVoi.setTen("Avoi");
        conVoi.setTuoi(3);
        conVoi.setGioiTinh("nu");
        conVoi.setSoChan(6);

        conVoi.an();
        conVoi.diLai();

        // tạo ra danh sách các con vật

        Animal[] danhSachCacConVat = new Animal[6];
        for (int i = 0; i < 6; i++) {
            Animal animal = new Animal();
            System.out.println("nhap vao ten con vat: ");
            String ten = new Scanner(System.in).nextLine();
            animal.setTen(ten);
            danhSachCacConVat[i] = animal;
        }
        System.out.println(Arrays.toString(danhSachCacConVat));

    }
}
