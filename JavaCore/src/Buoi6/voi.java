package Buoi6;

public class voi extends AnimalHai {

    private String loaiCo;

    public void hutNuoc() {
        System.out.println("voi dang hut nuoc");

    }

    @Override // ghi đè lại phương thức của lớp cha
    public void diChuyen() {
        System.out.println("voi di cham");
    }
}
