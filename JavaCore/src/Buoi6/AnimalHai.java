package Buoi6;

public class AnimalHai {


    private String ten;
    private String tuoi;
    private String noiO;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getNoiO() {
        return noiO;
    }

    public void setNoiO(String noiO) {
        this.noiO = noiO;
    }


    public void diChuyen() {
        System.out.println(this.ten + " dang di chuyen");

    }
}
