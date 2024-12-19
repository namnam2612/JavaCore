package Buoi8.BaiTap.XayDungAppQuanLyNhanSuCongTy;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Manager extends Employee {

    // khởi tạo mặc định cho list
    private List<Staff> danhSachNhanVien = new Vector<>();

    public Manager() {
        super();
        super.setLuongMotNgay(200);
    }

    public List<Staff> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(List<Staff> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("nhap thong tin quan ly: ");
        super.nhapThongTin();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("thong tin quan ly: ");
        super.hienThiThongTin();
        System.out.println("danh sach ma nhan vien cua quan ly: ");
        for (Staff staff : danhSachNhanVien) {
            System.out.println(staff.getMaNV() + " ");
        }
        System.out.println();
    }

    @Override
    public double cachTinhLuongThang() {
        System.out.println("Quan ly: ");
        return super.getLuongMotNgay() * super.getSoNgayLamViec() + (100 * danhSachNhanVien.size());
    }
}
