package Buoi4.BTVN;

import java.util.Arrays;
import java.util.Scanner;

public class Bai3V2 {

    public static int soLuongPhanTu = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap vao do dai cua mang: ");
        //int n = sc.nextInt();
        int n = 10;

        //int[] mangDoNguoiDungNhap = nhapMang(n, sc);

        int[] mangDoNguoiDungNhap = {9, 4, 5, 3, 2, 8, 7, 6, 1, 10};
        hienThi(mangDoNguoiDungNhap);


        boolean tiepTuc = true;
        do {
            System.out.println("\n<<--------------------------------------------------------------------------->>");
            System.out.println("<<1. TINH TONG CAC PHAN TU CHAN VA TONG CAC PHAN TU LE TRONG MANG            >>");
            System.out.println("<<2. TIM VA IN RA CAC SO NGUYEN TO TRONG MANG                                >>");
            System.out.println("<<3. SAP XEP MANG THEO CHAN LE                                               >>");
            System.out.println("<<4. CHIA MANG THANH HAI MANG CON                                            >>");
            System.out.println("<<5. TIM SO LUONG PHAN TU TRUNG LAP TRONG MANG VA IN RA CAC PHAN TU TRUNG LAP>>");
            System.out.println("<<6. THEM MOT PHAN TU VAO MANG                                               >>");
            System.out.println("<<7. XOA MOT PHAN TU KHOI MANG                                               >>");
            System.out.println("<<8.                  THOAT KHOI CHUONG TRINH                                >>");
            System.out.println("<<                     MOI BAN CH0N CHUC NANG                                >>");

            int x = sc.nextInt();


            switch (x) {
                case 1:
                    tinhTongPhanTuChanLe(mangDoNguoiDungNhap);

                    break;
                case 2:
                    soNguyenTo(mangDoNguoiDungNhap);
                    break;
                case 3:
                    sapxep(mangDoNguoiDungNhap);
                    break;
                case 4:
                    chiaMangThanhHaiMangCon(n, mangDoNguoiDungNhap);
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("ban da thoat chuong trinh");
                    tiepTuc = false;
                    break;
            }

        } while (tiepTuc);


        System.out.println("so luong phan tu trung lap trong mang la: ");
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            int ptu = mangDoNguoiDungNhap[i];
        }


    }


    private static void chiaMangThanhHaiMangCon(int n, int[] mangDoNguoiDungNhap) {
        int tong = 0;
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            tong += mangDoNguoiDungNhap[i];
        }
        int trungBinh = tong / mangDoNguoiDungNhap.length;


        int countMot = 0;
        int countHai = 0;
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] <= trungBinh) {
                countMot++;
            } else {
                countHai++;
            }

        }

        int[] mangConMot = new int[countMot];
        int[] mangConHai = new int[countHai];

        int indexMot = 0, indexHai = 0;
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] > trungBinh) {
                mangConHai[indexHai++] = mangDoNguoiDungNhap[i];
            } else {
                mangConMot[indexMot++] = mangDoNguoiDungNhap[i];
            }

        }

        System.out.println("mang con nho hon hoac bang trung binh mang la: " + Arrays.toString(mangConMot));
        System.out.println("mang con lon hon trung binh mang la: " + Arrays.toString(mangConHai));
    }


    private static void sapxep(int[] mangDoNguoiDungNhap) {
        // số chẵn giảm dần
        // số lẻ tăng dần
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] % 2 == 0) {
                for (int j = i + 1; j < mangDoNguoiDungNhap.length; j++) {
                    if (mangDoNguoiDungNhap[j] % 2 == 0 && mangDoNguoiDungNhap[i] < mangDoNguoiDungNhap[j]) {
                        int tam = mangDoNguoiDungNhap[i];
                        mangDoNguoiDungNhap[i] = mangDoNguoiDungNhap[j];
                        mangDoNguoiDungNhap[j] = tam;
                    }
                }
            }
        }

        // số lẻ tăng dần
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] % 2 != 0) {
                for (int j = i + 1; j < mangDoNguoiDungNhap.length; j++) {
                    if (mangDoNguoiDungNhap[j] % 2 != 0 && mangDoNguoiDungNhap[i] > mangDoNguoiDungNhap[j]) {
                        int tam = mangDoNguoiDungNhap[i];
                        mangDoNguoiDungNhap[i] = mangDoNguoiDungNhap[j];
                        mangDoNguoiDungNhap[j] = tam;
                    }
                }
            }
        }
        System.out.print("\nmang sau khi sap xep la: " + Arrays.toString(mangDoNguoiDungNhap));
    }

    private static void soNguyenTo(int[] mangDoNguoiDungNhap) {
        System.out.println("cac so nguyen to la");
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (!checkSoNguyenTo(mangDoNguoiDungNhap[i])) {
                continue;
            }
            System.out.print(mangDoNguoiDungNhap[i] + " ");

        }
    }

    private static boolean checkSoNguyenTo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }

    private static void tinhTongPhanTuChanLe(int[] mangDoNguoiDungNhap) {
        int tongLe = 0;
        int tongChan = 0;

        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            if (mangDoNguoiDungNhap[i] % 2 == 0) {
                tongChan += mangDoNguoiDungNhap[i];
            } else {
                tongLe += mangDoNguoiDungNhap[i];
            }

        }
        System.out.println("\n" + "tong cac phan tu le la: " + tongLe);
        System.out.println("tong cac phan tu le la: " + tongChan);
    }

    private static void hienThi(int[] mangDoNguoiDungNhap) {
        System.out.println("mang do nguoi dung nhap vao la: ");
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            System.out.print(mangDoNguoiDungNhap[i] + "\t");

        }
    }

    private static int[] nhapMang(int n, Scanner sc) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("nhap vao phan tu cua mang" + (i + 1));
            array[i] = sc.nextInt();
            soLuongPhanTu++;

        }
        return array;
    }
}