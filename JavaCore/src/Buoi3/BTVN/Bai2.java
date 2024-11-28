package Buoi3.BTVN;

import java.util.Scanner;

public class Bai2 {
    /*
    doi sang so nhi phan cua 1 so nguyen duong n
    vi du nhap vao so duong 8 in ra man hinh so nhi phan cua no la 1000
    7 -> 111
    9 -> 1001
    16 -> 10000
    */
    public static void main(String[] args) {
        Bai2 doiSo = new Bai2();
        int n = doiSo.getN();
        doiSo.doiSoNhiPhan(n);
    }

    public static int getN() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("moi ban nhap so nguyen duong:");
            n = sc.nextInt();
        } while (n <= 0);
        return n;
    }

    private void doiSoNhiPhan(int n) {
        String soNhiPhan = "";
        while (n != 0) {
            int soDu = n % 2;
            soNhiPhan = soDu + soNhiPhan;
            n = n / 2;
        }
        System.out.println("So nhi phan la: " + soNhiPhan);
    }
}
