package Buoi3.BTVN;

/*
Đề bài: Kiểm tra và phân loại số trong một dãy
Mô tả bài toán: Viết chương trình thực hiện các yêu cầu sau trên một dãy số nguyên dương nhập vào từ người dùng:
1. Kiểm tra xem số đó có phải là số hoàn hảo hay không.
2. Kiểm tra xem số đó có phải là số Armstrong hay không.
3. Kiểm tra xem số đó có phải là số đối xứng hay không.
4. Tính tổng các chữ số của mỗi số trong dãy.
Yêu cầu chi tiết:

1. Nhập vào một dãy số nguyên dương n1,n2…nk từ người dùng.
2. Với mỗi số trong dãy:
o In ra thông báo số đó là số hoàn hảo hay không.
o In ra thông báo số đó là số Armstrong hay không.
o In ra thông báo số đó là số đối xứng hay không.
o Tính tổng các chữ số và in kết quả.

Input:

· Một dãy số nguyên dương n1,n2,n3…,nk
· Ví dụ: 153 6 121 10 9474

Output:

· Kiểm tra cho mỗi số trong dãy:
o Kiểm tra số hoàn hảo.
o Kiểm tra số Armstrong.
o Kiểm tra số đối xứng.
o Tổng các chữ số của số đó

Ví dụ nhập vào:

153 6 121 10 9474

Ví dụ đầu ra:

153 là số Armstrong.
Tổng các chữ số của 153 là: 9.

6 là số hoàn hảo.
6 là số Armstrong.
6 là số đối xứng.
Tổng các chữ số của 6 là: 6.

121 là số đối xứng.
Tổng các chữ số của 121 là: 4.
10 không phải là số Armstrong.
10 không phải là số hoàn hảo.
10 không phải là số đối xứng.
Tổng các chữ số của 10 là: 1.

9474 là số Armstrong.
9474 là số đối xứng.
Tổng các chữ số của 9474 là: 29.

-hoan hao:
    tong cac uoc cua so hoan hao bang chinh no
    uoc cua 1 so n la k khi n % k = 0;

    ý tưởng:
        duyệt từ 1 cho đến số n
            -> nếu n % i == 0
                -> cộng tổng các số i
            nếu tổng các số i == n
                -> số hoàn hảo
*/
public class Bai3 {
    public static void main(String[] args) {
        System.out.println("1 " + kiemTraSoHoanHao(6));
        System.out.println("2 " + kiemTraSoArmstrong(153));
        System.out.println("3 " + laSoDoiXung(10));
        System.out.println("4 " + tinhTongCacChuSo(10));
    }

    public static int tinhTongCacChuSo(int n) {
        int chuSoCuoi = 0;
        int tong = 0;
        while (n != 0) {
            chuSoCuoi = n % 10;
            tong += chuSoCuoi;
            n = n / 10;
        }
        return tong;
    }

    public static boolean laSoDoiXung(int n) {
        int soN = n;
        int soDoiXung = 0;
        int soTam = 0;
        while (soN != 0) {
            soTam = soN % 10;
            soDoiXung = soDoiXung * 10 + soTam;
        }
        if (soDoiXung == soN) {
            return true;
        }
        return false;
    }

    public static boolean kiemTraSoHoanHao(int n) {
        int tongTam = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                tongTam += i;
            }
        }
        if (tongTam == n) {
            return true;
        }
        return false;
    }

    public static boolean kiemTraSoArmstrong(int n) {
        int soN = n;
        int soCacChuSo = 0;

        while (soN != 0) {
            soN = soN % 10;
            soCacChuSo++;
        }
        System.out.println("so cac chu so: " + soCacChuSo);

        int chuSo = 0;
        int tong = 0;
        while (soN != 0) {
            chuSo = soN % 10;
            tong += Math.pow(chuSo, soCacChuSo);
            soN = soN / 10;
        }
        if (tong == n) {
            return true;
        }
        return false;


    }


}
