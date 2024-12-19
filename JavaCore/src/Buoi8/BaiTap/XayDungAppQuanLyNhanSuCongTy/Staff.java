package Buoi8.BaiTap.XayDungAppQuanLyNhanSuCongTy;

public class Staff extends Employee {

    public Manager truongPhong;

    public Staff() {
        // khởi tạo đối tượng cha
        super();
        // khởi tạo giá trị lương của nhân viên đều là 100
        super.setLuongMotNgay(100);
    }

    @Override
    public double cachTinhLuongThang() {
        System.out.println("nhan vien: ");
        return super.getLuongMotNgay() * super.getSoNgayLamViec();
    }

    public Manager getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(Manager truongPhong) {
        this.truongPhong = truongPhong;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("nhap thong tin nhan vien: ");
        super.nhapThongTin();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("thong tin nhan vien: ");
        super.hienThiThongTin();
        if (truongPhong != null) {
            System.out.println("Thong tin quan ly: " + truongPhong.getMaNV() + " | " + truongPhong.getHoTen());
        }

    }
}
