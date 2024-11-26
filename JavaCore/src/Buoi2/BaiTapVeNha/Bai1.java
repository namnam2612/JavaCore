package Buoi2.BaiTapVeNha;

import java.util.Scanner;

/*

Viết chương trình Java tính điểm của sinh viên.

Chương trình này sẽ đọc vào các loại điểm của sinh viên (điểm chuyên cần, điểm giữa kỳ, và điểm cuối kỳ) và xếp loại điểm theo quy luật sau:

– if điểm trung bình >=9 =>loại=A

– if điểm trung bình >= 7 và <9 => loại=B

– if điểm trung bình>=5 and <7 =>loại=C

– if điểm trung bình<5 =>loại=D

 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap diem chuyen can: ");
        double diemChuyenCan = scanner.nextDouble();
        System.out.println("nhap diem giua ky: ");
        double diemGiuaKy = scanner.nextDouble();
        System.out.println("nhap diem cuoi ky: ");
        double diemCuoiKy = scanner.nextDouble();

        double diemTrungBinh = (diemChuyenCan + diemGiuaKy + diemCuoiKy) / 3;
        System.out.println("diem trung binh cua ban la:\t" + diemTrungBinh);

        if (diemTrungBinh >= 9) {

            System.out.println("xep loai A");

        } else if (diemTrungBinh >= 7) {
            System.out.println("xep loai B");

        } else if (diemTrungBinh >= 5) {
            System.out.println("xep loai C");

        } else {
            System.out.println("xep loai D");

        }

    }
}
