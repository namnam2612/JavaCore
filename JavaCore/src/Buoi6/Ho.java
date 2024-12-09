package Buoi6;

public class Ho extends AnimalHai {

    public String loaiThit;

    public void sanMoi() {
        super.diChuyen();
    }

    @Override // ghi đè lại phương thức của lớp cha
    public void diChuyen() {
        System.out.println("ho di chuyen nhanh");
    }
}
