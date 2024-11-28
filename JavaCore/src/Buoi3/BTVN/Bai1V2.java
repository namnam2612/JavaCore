package Buoi3.BTVN;

public class Bai1V2 {
    public static void main(String[] args) {
        int tong = 200000;
        int tien1 = 1000;
        int tien2 = 2000;
        int tien3 = 5000;

        int tongSoTo1 = tong / tien1;
        int tongSoTo2 = tong / tien2;
        int tongSoTo3 = tong / tien3;
        int count = 0;

        for(int i = 1; i <= tongSoTo1; i++) {
            int soToTien1 = i;
            for (int j = 1; j <= tongSoTo2; j++) {
                int soToTien2 = j;
                for(int k = 1; k <= tongSoTo3; k++) {
                    int soToTien3 = k;

                    int tongTien1 = soToTien1 * tien1;
                    int tongTien2 = soToTien2 * tien2;
                    int tongTien3 = soToTien3 * tien3;
                    int tongTam = tongTien1 + tongTien2 + tongTien3;
                    count += 1;
                    if(tongTam == tong) {
                        System.out.println("co " + count + " cach chon so to tien");

                    }
                }
            }
        }
    }
}
