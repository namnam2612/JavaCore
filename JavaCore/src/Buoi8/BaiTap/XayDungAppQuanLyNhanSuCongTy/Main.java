package Buoi8.BaiTap.XayDungAppQuanLyNhanSuCongTy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        int type = 0;
        do {
            System.out.println("nhap cac chuc nang: ");
            System.out.println("1. Nhap thong tin cong ty");
            System.out.println("2. Phan bo nhan vien va truong phong");
            System.out.println("3. them mot nhan su");
            System.out.println("4. xoa mot nhan su");
            System.out.println("5. hien thi danh sach nhan vien");
            System.out.println("6. Tinh va xuat luong cho cong ty");
            System.out.println("7. Tim nhan vien thuong co luong cao nhat");
            System.out.println("8. Tim truong phong co so luong nhan vien duoi quyen nhieu nhat");
            System.out.println("9. Sap xep toan bo nhan vien trong cong ty voi thu tu ABC");
            System.out.println("10. Sap xep toan bo nhan vien trong cong ty voi luong giam dan");
            System.out.println("10. Tim giam doc co luong co phieu nhieu nhat");
            System.out.println("12. Hien thi tong thu nhap cua tung giam doc");
            System.out.println("13. thoat");
            type = new Scanner(System.in).nextInt();

            switch (type) {
                case 1:
                    company.nhapThongTinCongTy();
                    break;
                case 2:
                    company.phanBoNhanVienVaoPhong();
                    break;
                case 3:
                    company.themNhanSu();
                    break;
                case 4:
                    company.xoaNhanVien();
                    break;
                case 5:
                    company.hienThiDanhSachNhanVien();
                    break;
                case 6:
                    System.out.println("thoat");
                    break;
            }
        } while (type != 6);

    }
}
