package Buoi5.BaiTap;

public class car {

    // đặc điểm
    public String hangSanxuat;
    public String model;
    public int nam;
    public String mau;

    // hành động
    // thường để private để bảo vệ đối tượng
    public void khoiDong() {
        System.out.println("o to: " + model + " khoi dong");
    }

    public void dung() {
        System.out.println("o to: " + model + " dung");
    }

    public void phanh() {
        System.out.println("o to: " + model + " phanh");
    }

    public void batCanGatNuoc() {
        System.out.println("o to: " + model + " bat gat nuoc");
    }

}
