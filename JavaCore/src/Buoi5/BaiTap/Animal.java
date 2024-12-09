package Buoi5.BaiTap;

public class Animal {
    // đặc điểm
    private String ten;
    private int tuoi;
    private String mauLong;
    private int soChan;
    private String gioiTinh;


    //hành vi
    public void an() {
        System.out.println(ten + " dang an");
    }

    public void diLai() {
        System.out.println(ten + " dang di bang " + soChan + " chan");
    }

    public String getTen() {
        return ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getMauLong() {
        return mauLong;
    }

    public int getSoChan() {
        return soChan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }


    //construction khởi tạo thay cho getter, setter
    public void Animal(String ten) {
        this.ten = ten;
    }

    public Animal() {
        // phải tạo kèm constructor không tham số, nếu không thì lỗi
    }

    // getter, setter
    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setMauLong(String mauLong) {
        this.mauLong = mauLong;
    }

    public void setSoChan(int soChan) {
        this.soChan = soChan;
    }


}
