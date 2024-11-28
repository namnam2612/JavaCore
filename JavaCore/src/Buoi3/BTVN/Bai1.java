package Buoi3.BTVN;

public class Bai1 {
    /*
    can co tong cong 200.000d tu 3 loai giay bac 1000d, 2000d va 5000d
    lap chuong trinh de tim tat ca cac phuong an co the
    */

    public static void main(String[] args) {
        int count = 0;

        for (int x = 0; x <= 40; x++) {
            for (int y = 0; y <= 100; y++) {
                int giaTriConLai = 200000 - (5000 * x) - (2000 * y);
                if (giaTriConLai >= 0 && giaTriConLai % 1000 == 0) {
                    int z = giaTriConLai / 1000;
                    System.out.println("Phương án: " + x + " tờ 1.000đ, " + y + " tờ 2.000đ, " + z + " tờ 5.000đ");
                    count++;
                }
            }
        }
        System.out.printf("co tong so %d so lan chon 200.000 ", count);
    }
}
