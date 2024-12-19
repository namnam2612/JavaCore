package Buoi8.BaiTap.XayDungAppQuanLyNhanSuCongTy;

import java.util.Scanner;

public abstract class Employee {
    private String maNV;
    private String hoTen;
    private String sdt;
    private int soNgayLamViec;
    private Double luongMotNgay; //Double chứa được giá trị kiểu null

    // kiểu dữ liệu đối tượng
    //khởi tạo đối tượng trong heap như 1 đối tượng bình thường
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin ma nhan vien: ");
        this.maNV = sc.nextLine();
        System.out.println("Nhap thong tin ho ten: ");
        this.hoTen = sc.nextLine();
        System.out.println("Nhap sdt: ");
        this.sdt = sc.nextLine();
        System.out.println("nhap so ngay lam viec: ");
        this.soNgayLamViec = sc.nextInt();
        System.out.println("nhap luong mot ngay");
        this.luongMotNgay = sc.nextDouble();
    }

    public void hienThiThongTin() {
        System.out.println("Ma nhan vien: " + maNV);
        System.out.println("Ho ten: " + hoTen);
        System.out.println("So dien thoai: " + sdt);
        System.out.println("So ngay lam viec: " + soNgayLamViec);
        System.out.println("Luong mot ngay: " + luongMotNgay);

    }

    public abstract double cachTinhLuongThang(); // double không chứa được kiểu giá trị null
    // chỉ lưu trong stack

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public double getLuongMotNgay() {
        return luongMotNgay;
    }

    public void setLuongMotNgay(double luongMotNgay) {
        this.luongMotNgay = luongMotNgay;
    }
}
