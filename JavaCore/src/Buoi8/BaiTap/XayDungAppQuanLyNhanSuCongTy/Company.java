package Buoi8.BaiTap.XayDungAppQuanLyNhanSuCongTy;

import java.util.*;

public class Company {
    private String tenCongTy;
    private int maSoThue;
    private double doanhThuThang;
    private final List<Employee> danhSachNhanVien = new ArrayList<>();

    public void nhapThongTinCongTy() {
        System.out.println("nhap ten cong ty");
        this.tenCongTy = new Scanner(System.in).nextLine();
        System.out.println("nhap ma so thue");
        this.maSoThue = new Scanner(System.in).nextInt();
        System.out.println("nhap doanh thu thang");
        this.doanhThuThang = new Scanner(System.in).nextDouble();
    }

    public void hienThiDanhSachNhanVien() {
        System.out.println();
        System.out.println("-------thông tin toàn bộ nhân viên trong công ty---------");
        for (Employee employee : danhSachNhanVien) {
            employee.hienThiThongTin();
        }
        System.out.println();

    }


    public void themNhanSu() {
        System.out.println("them mot nhan vien: ");
        Employee employee = chonLoaiNhanVien();
        if (employee == null) {
            return;
        }
        employee.nhapThongTin();
        danhSachNhanVien.add(employee);
    }

    public void timNhanVienCoLuongCaoNhat() {
        System.out.println("duyet qua danh sach nhan vien");
        Double maxLuong = Double.MIN_VALUE;
        Employee employee = null;
        for (Employee e : danhSachNhanVien) {
            if (!(e instanceof Staff)) {
                continue;
            }
            // nếu lương của nhân viên được duyệt > lương max hiện tại
            if (e.cachTinhLuongThang() > maxLuong) {
                // gán data
                maxLuong = e.cachTinhLuongThang();
                employee = e;

            }
        }
        if (employee != null) {
            System.out.println("nhan vien co luong cao nhat la: ");
            employee.hienThiThongTin();
            return;
        }
        System.out.println("khong tim thay nhan vien");
    }

    /**
     * c2: su dung stream, method referent
     * Optional: là 1 class cung cấp sẵn các hàm để kiểm tra null hoặc tính ton tại của object, thay cho việc
     * phải sử dụng các biểu thức != null, === null,.....
     */
    public void timNhanVienMaxLuongC2() {
        Optional<Employee> employeeOptional = danhSachNhanVien.stream() // bien danh sach thanh stream
                .max( // su dung ham max tim ra phan tu co gia tri lon nhat voi dieu kien duoc tinh bang
                        Comparator.comparingDouble(employee -> employee.cachTinhLuongThang()) // su dung ham cach tinh luong de so sanh: su dung method referent thay cho lamda employee -> employee.cachTinhLuongThang()
                );
        if (employeeOptional.isPresent()) {

            System.out.println("Nhan vien co luong cao nhat la: ");
            Employee employee = employeeOptional.get(); // lay ra value ob tu optional su dung ham get
            employee.hienThiThongTin();
            return;
        }
        System.out.println("khong tim thay");
    }

    public void tinhTongLuong() {

        System.out.println("Hien thi tong luong cua tat ca nhan vien trong cong ty");
        double tong = 0;
        // duyệt toàn bộ danh sách nhân viên
        for (Employee employee : danhSachNhanVien) {
            //tính tổng lương của từng nhân viên và cộng la
            System.out.println("Luong cua nhan vien: " + employee.getMaNV() + " so ngay lam viec " + employee.getSoNgayLamViec() + " Luong mot ngay: " + employee.getLuongMotNgay() + " = " + employee.cachTinhLuongThang());
            /** vi java co tinh da hinh nen o danhSachNhanVien nhan vien se bao gom ca staff, manager, director
             mà mỗi class đều đã ghi đè hàm cachTinhLuongThang => khi runtime employee sẽ tự động sử dụng cách tính lương thang
             của các class đã ghi đè
             * */
            tong += employee.cachTinhLuongThang();
        }
    }

    public void tinhTongLuongC2() {
        //
        double tong = this.danhSachNhanVien.stream() // biến list employee thành kiểu dữ liệu stream
                .mapToDouble( // bien list employee thanh 1 list cac so double bang return
                        employee -> employee.cachTinhLuongThang()).sum(); // su dung ham sum de tinh tong
        System.out.println("Tong luong thang cua cong ty la: " + tong);
    }

    private Employee chonLoaiNhanVien() {
        Employee employee = null;
        System.out.println("chon chuc vu muon them");

        System.out.println("1. Giam doc");
        System.out.println("2. Quan ly");
        System.out.println("3. Nhan vien");
        int luaChon = new Scanner(System.in).nextInt();

        switch (luaChon) {
            case 1:
                employee = new Director();
                break;
            case 2:
                employee = new Manager();
                break;
            case 3:
                employee = new Staff();
            case 4:
                System.out.println("thoat");
                break;
            default:
                System.out.println("khong hop le !");
                break;
        }
        return employee;
    }


    public void xoaNhanVien() {
        // nhập vào mã nhân viên muốn xóa
        System.out.println("Nhap vao ma nhan vien can xoa: ");
        String maNVXoa = new Scanner(System.in).nextLine();
        // tìm kiếm
        Employee employeedelete = timKiemNhanVien(maNVXoa);
        if (employeedelete == null) {
            System.out.println("khong tim thay nhan vien voi ma " + maNVXoa);
            return;
        }
        // xóa
        if (employeedelete instanceof Director || employeedelete instanceof Staff) {
            this.danhSachNhanVien.remove(employeedelete);
        } else if (employeedelete instanceof Manager) {

            xoaTruongPhongVaNhanVien(maNVXoa);
            // nếu là instanceof Manager => ép kiểu biến employeedelete thành đối tượng kiểu Manager
            this.danhSachNhanVien.remove(employeedelete);
        }
        System.out.println("xoa nhan vien thanh cong");
    }

    public void phanBoNhanVienVaoPhong() {
        System.out.println("Nhap vao ma nhan vien muon dua vao quan ly: ");
        String maNV = new Scanner(System.in).nextLine();
        // kiem tra xem co ton tai nhan vien trong danh sach nhan vien khong
        Employee employee = timKiemNhanVien(maNV);
        if (!(employee instanceof Staff)) {
            System.out.println("khong ton tai nhan vien voi ma: " + maNV);
            return;
        }

        Staff staff = ((Staff) employee);
        // kiem tra nhan vien đó đã được đưa vào phòng nào chưa

        if (staff.getTruongPhong() != null) {
            System.out.println("nhan vien " + maNV + " da duoc dua vao cho quan ly " + staff.getTruongPhong().getMaNV());
            return;
        }

        System.out.println("Nhap vao ma nhan vien cua quan ly: ");
        String maNVQuanLy = new Scanner(System.in).nextLine();
        Employee employeeManager = timKiemNhanVien(maNVQuanLy);

        if (!(employeeManager instanceof Manager)) {
            System.out.println("khong ton tai ma nhan vien voi ma nhan vien " + maNVQuanLy);
            return;
        }
        Manager manager = ((Manager) employeeManager);

        // set quan ly cho nhan vien
        staff.setTruongPhong(manager);
        // them nhan vien vao cho quan ly
        List<Staff> staffManager = manager.getDanhSachNhanVien();
        staffManager.add(staff);

    }

    private void xoaTruongPhongVaNhanVien(String maNVXoa) {
        //lấy danh sách nhân viên trong Manager, và set null director
        // tìm danh sách nhân viên có manager cần xóa
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : this.danhSachNhanVien) {
            // kiểm tra nếu không phải nhân vieen => bỏ qua
            if (employee instanceof Director || employee instanceof Manager) {
                continue;
            }
            // neu là nhân viên kiểm tra có thuộc về giám đốc đó hay không, ép kiểu về kiểu nhân viên
            Staff staff = ((Staff) employees);
            if (staff.getTruongPhong() != null && staff.getTruongPhong().getMaNV().equalsIgnoreCase(maNVXoa)) {
                staff.setTruongPhong(null);
            }
        }
    }

    public Employee timKiemNhanVien(String maNV) {
        for (Employee employee : this.danhSachNhanVien) {
            if (maNV.equalsIgnoreCase(employee.getMaNV())) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public int getMaSoThue() {
        return maSoThue;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }


    public void setMaSoThue(int maSoThue) {
        this.maSoThue = maSoThue;
    }

    public double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }


}
