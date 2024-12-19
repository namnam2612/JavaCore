package Buoi8.BaiTap.XayDungAppQuanLyNhanSuCongTy;

import java.util.Scanner;

public class Director extends Employee {
    private Double coPhan;

    public Director(Double coPhan) {
        super();
        super.setLuongMotNgay(300);
    }

    public Director() {

    }

    public Double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(Double coPhan) {
        this.coPhan = coPhan;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("nhap thong tin giam doc: ");
        System.out.println("nhap thong tin co phan(theo phan tram khong duoc vuot qua 100%): ");
        boolean khongHopLe = true;
        do {
            this.coPhan = new Scanner(System.in).nextDouble();
            if (this.coPhan > 0 && this.coPhan <= 100) {
                khongHopLe = false;
            } else {
                System.out.println("sai, moi nhap lai");
            }
        } while (khongHopLe);
        super.nhapThongTin();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("hien thi thong tin giam doc: ");

        super.hienThiThongTin();
    }

    @Override
    public double cachTinhLuongThang() {
        System.out.println("Giam doc: ");
        return super.getLuongMotNgay() * super.getSoNgayLamViec();
    }
}
