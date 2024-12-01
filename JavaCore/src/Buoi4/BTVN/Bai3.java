package Buoi4.BTVN;

import java.util.*;

/**
 * Mô tả bài toán:
 * <p>
 * Bạn sẽ xây dựng một chương trình Java có thể thực hiện các tác vụ phức tạp sau:
 * 1. Nhập một mảng các số nguyên.
 * 2. Tính tổng các phần tử chẵn và tổng các phần tử lẻ trong mảng.
 * 3. Tìm và in ra các số nguyên tố có trong mảng.
 * 4. Sắp xếp mảng sao cho:
 * <p>
 * + Các phần tử chẵn được sắp xếp theo thứ tự giảm dần.
 * <p>
 * + Các phần tử lẻ được sắp xếp theo thứ tự tăng dần.
 * <p>
 * <p>
 * 5. Chia mảng thành 2 mảng con:
 * <p>
 * + Mảng 1: Chứa tất cả các phần tử có giá trị nhỏ hơn hoặc bằng trung bình của mảng.
 * <p>
 * + Mảng 2: Chứa tất cả các phần tử có giá trị lớn hơn trung bình của mảng.
 * <p>
 * 6. Tìm số lượng phần tử trùng lặp trong mảng và in ra các phần tử trùng lặp.
 * <p>
 * 7. Thêm một phần tử vào mảng:
 * <p>
 * + Cho phép người dùng thêm một phần tử vào mảng tại vị trí chỉ định (index).
 * <p>
 * + Nếu mảng đã đầy, tự động mở rộng mảng.
 * <p>
 * 8. Xoá một phần tử khỏi mảng:
 * <p>
 * + Cho phép người dùng nhập vào một giá trị phần tử và xoá phần tử đó trong mảng.
 * <p>
 * Yêu cầu:
 * <p>
 * 1. Nhập mảng: Bạn sẽ nhập một mảng các số nguyên từ bàn phím.
 * <p>
 * 2. Tìm số nguyên tố: Viết một hàm để kiểm tra xem một số có phải là số nguyên tố hay không, sau đó tìm và in ra tất cả các số nguyên tố trong mảng.
 * <p>
 * 3. Chia mảng thành hai mảng con:
 * <p>
 * + Tính trung bình của mảng.
 * <p>
 * + Duyệt qua các phần tử và chia chúng thành 2 mảng con: một mảng chứa các phần tử nhỏ hơn hoặc bằng trung bình, mảng còn lại chứa các phần tử lớn hơn trung bình.
 * <p>
 * 4. Thêm phần tử vào mảng: Bạn cần thêm một phần tử vào mảng tại chỉ định index. Nếu mảng đã đầy, mở rộng mảng tự động.
 * <p>
 * 5. Xoá phần tử khỏi mảng: Xoá một phần tử trong mảng nếu phần tử đó tồn tại.
 */

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap chieu dai cua mang ");

        int n = sc.nextInt();

        int[] mangNguoiDungNhap = mangDoNguoiDungNhap(n, sc);

        xuatMangDoNguoiDungNhap(mangNguoiDungNhap);


        System.out.println("<<--------------------------------------------------------------------------->>");
        System.out.println("<<1. TÍNH TỔNG CÁC PHẦN TỬ CHẴN VÀ TỔNG CÁC PHẦN TỬ LẺ TRONG MẢNG            >>");
        System.out.println("<<2. TÌM VÀ IN RA CÁC SỐ NGUYÊN TỐ TRONG MẢNG                                >>");
        System.out.println("<<3. SẮP XẾP MẢNG THEO CHẴN LẺ                                               >>");
        System.out.println("<<4. CHIA MẢNG THÀNH HAI MẢNG CON                                            >>");
        System.out.println("<<5. TÌM SỐ LƯỢNG PHẦN TỬ TRÙNG LẶP TRONG MẢNG VÀ IN RA CÁC PHẦN TỬ TRÙNG LẶP>>");
        System.out.println("<<7. THÊM MỘT PHẦN TỬ VÀO MẢNG                                               >>");
        System.out.println("<<8. XÓA MỘT PHẦN TỬ KHỎI MẢNG                                               >>");
        System.out.println("<<9.                  THOÁT KHỎI CHƯƠNG TRÌNH                                >>");
        System.out.println("<<                     MOI BAN CH0N CHUC NANG                                >>");


        int x = sc.nextInt();

        switch (x) {
            case 1:
                tinhTongSoChanSoLe(mangNguoiDungNhap);
                break;
            case 2:
                soNguyenToTrongMang(mangNguoiDungNhap);
                break;
            case 3:
                sapxep(mangNguoiDungNhap);
                break;
            case 4:
                chiaHaiMangCon(mangNguoiDungNhap);
                break;
            case 5:
                soLuongPhanTuTrungLap(mangNguoiDungNhap);
                break;
            case 6:
                themMotPhanTuVaoMangTheoViTriDaChiDinh(sc, mangNguoiDungNhap);
                break;
            case 7:
                xoaPhanTuKhoiMang(sc, mangNguoiDungNhap);
                break;
            default:
                System.out.println("KẾT THÚC CHƯƠNG TRÌNH");
                break;
        }

    }

    private static void xoaPhanTuKhoiMang(Scanner sc, int[] mangNguoiDungNhap) {
        // Xóa phần tử khỏi mảng
        System.out.println("\nNhập giá trị phần tử muốn xóa: ");
        int giaTriCanXoa = sc.nextInt();

        mangNguoiDungNhap = xoaPhanTuKhoiMang(mangNguoiDungNhap, giaTriCanXoa);

        // In ra mảng sau khi xóa phần tử
        System.out.println("\nMảng sau khi xóa phần tử: ");
        xuatMangDoNguoiDungNhap(mangNguoiDungNhap);
    }

    private static int[] xoaPhanTuKhoiMang(int[] mang, int giaTri) {
        // Tìm phần tử trong mảng
        int index = -1;
        for (int i = 0; i < mang.length; i++) {
            if (mang[i] == giaTri) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Phần tử không tồn tại trong mảng.");
            return mang;
        }

        // Tạo mảng mới có kích thước nhỏ hơn 1
        int[] mangMoi = new int[mang.length - 1];

        // Sao chép các phần tử trước vị trí phần tử cần xóa
        for (int i = 0; i < index; i++) {
            mangMoi[i] = mang[i];
        }

        // Sao chép các phần tử sau vị trí phần tử cần xóa
        for (int i = index + 1; i < mang.length; i++) {
            mangMoi[i - 1] = mang[i];
        }

        return mangMoi;
    }

    private static void themMotPhanTuVaoMangTheoViTriDaChiDinh(Scanner sc, int[] mangNguoiDungNhap) {
        // Thêm phần tử vào mảng tại vị trí chỉ định
        System.out.println("\nNhập vị trí muốn thêm phần tử (index bắt đầu từ 0): ");
        int index = sc.nextInt();

        System.out.println("Nhập phần tử cần thêm: ");
        int phanTu = sc.nextInt();

        mangNguoiDungNhap = themPhanTuVaoMang(mangNguoiDungNhap, index, phanTu);

        // In ra mảng sau khi thêm phần tử
        System.out.println("\nMảng sau khi thêm phần tử: ");
        xuatMangDoNguoiDungNhap(mangNguoiDungNhap);
    }

    private static int[] themPhanTuVaoMang(int[] mang, int index, int phanTu) {
        if (index < 0 || index > mang.length) {
            System.out.println("Vị trí không hợp lệ.");
            return mang;
        }

        // Mở rộng mảng
        mang = Arrays.copyOf(mang, mang.length + 1);

        // Di chuyển các phần tử sau vị trí chèn 1 ô sang phải
        for (int i = mang.length - 1; i > index; i--) {
            mang[i] = mang[i - 1];
        }

        // Chèn phần tử mới vào vị trí chỉ định
        mang[index] = phanTu;

        return mang;
    }

    private static void soLuongPhanTuTrungLap(int[] mangNguoiDungNhap) {
        // Tạo HashMap để lưu trữ số lần xuất hiện của mỗi phần tử
        Map<Integer, Integer> map = new HashMap<>();

        // Duyệt qua mảng để đếm số lần xuất hiện của từng phần tử
        for (int num : mangNguoiDungNhap) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Kiểm tra các phần tử trong HashMap và in ra các phần tử trùng lặp
        System.out.println("Các phần tử trùng lặp và số lần xuất hiện:");
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) { // Nếu số lần xuất hiện lớn hơn 1, là phần tử trùng lặp
                System.out.println(entry.getKey() + " xuất hiện " + entry.getValue() + " lần.");
                count++;
            }
        }

        // Nếu không có phần tử trùng lặp
        if (count == 0) {
            System.out.println("Không có phần tử trùng lặp trong mảng.");

        }
    }

    private static void chiaHaiMangCon(int[] mangNguoiDungNhap) {
        double trungBinh = tinhTrungBinhMang(mangNguoiDungNhap);

        // Khai báo 2 mảng con sử dụng ArrayList để dễ dàng thêm phần tử
        ArrayList<Integer> mang1 = new ArrayList<>();
        ArrayList<Integer> mang2 = new ArrayList<>();

        // Duyệt qua mảng và phân loại phần tử vào 2 mảng con
        for (int num : mangNguoiDungNhap) {
            if (num <= trungBinh) {
                mang1.add(num);  // Thêm vào mảng 1 nếu nhỏ hơn hoặc bằng trung bình
            } else {
                mang2.add(num);  // Thêm vào mảng 2 nếu lớn hơn trung bình
            }
        }

        // In ra mảng 1 và mảng 2
        System.out.println("Mảng 1 (nhỏ hơn hoặc bằng trung bình): " + mang1);
        System.out.println("Mảng 2 (lớn hơn trung bình): " + mang2);
    }

    private static double tinhTrungBinhMang(int[] mangNguoiDungNhap) {
        int tong = 0;
        for (int num : mangNguoiDungNhap) {
            tong += num;

        }
        return (double) tong / mangNguoiDungNhap.length;
    }

    private static void sapxep(int[] mangNguoiDungNhap) {
        // Tạo 2 mảng riêng biệt cho các phần tử chẵn và lẻ
        int[] mangChan = new int[mangNguoiDungNhap.length];
        int[] mangLe = new int[mangNguoiDungNhap.length];

        int indexChan = 0, indexLe = 0;

        // Phân loại các phần tử chẵn và lẻ
        for (int num : mangNguoiDungNhap) {
            if (num % 2 == 0) {
                mangChan[indexChan++] = num;  // Số chẵn
            } else {
                mangLe[indexLe++] = num;  // Số lẻ
            }
        }

        // Cắt mảng con chính xác
        mangChan = Arrays.copyOf(mangChan, indexChan);
        mangLe = Arrays.copyOf(mangLe, indexLe);

        // Sắp xếp mảng chẵn giảm dần
        Arrays.sort(mangChan);
        for (int i = 0; i < mangChan.length / 2; i++) {
            int temp = mangChan[i];
            mangChan[i] = mangChan[mangChan.length - 1 - i];
            mangChan[mangChan.length - 1 - i] = temp;
        }

        // Sắp xếp mảng lẻ tăng dần
        Arrays.sort(mangLe);

        // Cập nhật lại mảng gốc
        int indexChanSorted = 0, indexLeSorted = 0;
        for (int i = 0; i < mangNguoiDungNhap.length; i++) {
            if (mangNguoiDungNhap[i] % 2 == 0) {
                mangNguoiDungNhap[i] = mangChan[indexChanSorted++];
            } else {
                mangNguoiDungNhap[i] = mangLe[indexLeSorted++];
            }
        }
        System.out.println("\nMảng sau khi sắp xếp: " + Arrays.toString(mangNguoiDungNhap));
    }

    private static void soNguyenToTrongMang(int[] mangNguoiDungNhap) {

        System.out.println("cac so nguyen to co trong mang la: ");
        for (int i = 0; i < mangNguoiDungNhap.length; i++) {
            if (checkSoNguyenTo(mangNguoiDungNhap[i])) {
                System.out.print(mangNguoiDungNhap[i] + " ");
            }
        }
    }

    private static boolean checkSoNguyenTo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void tinhTongSoChanSoLe(int[] mangNguoiDungNhap) {
        int countChan = 0;
        int countLe = 0;
        for (int i = 0; i < mangNguoiDungNhap.length; i++) {
            if (mangNguoiDungNhap[i] % 2 == 0) {
                countChan += mangNguoiDungNhap[i];
            } else {
                countLe += mangNguoiDungNhap[i];
            }

        }
        System.out.println("tong cac phan tu chan la: " + countChan);
        System.out.println("tong cac phan tu le la: " + countLe);
    }

    private static void xuatMangDoNguoiDungNhap(int[] mangDoNguoiDungNhap) {
        System.out.println("cac so nguoi dung nhap vao mang la: ");
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {

            int duLieuMang = mangDoNguoiDungNhap[i];
            System.out.println(duLieuMang + "\t");

        }
    }

    private static int[] mangDoNguoiDungNhap(int n, Scanner sc) {
        int[] mangDoNguoiDungNhap = new int[n];
        int duLieuMang = 0;
        for (int i = 0; i < mangDoNguoiDungNhap.length; i++) {
            System.out.println("nhap vao phan tu co index: " + (i + 1));
            duLieuMang = sc.nextInt();
            mangDoNguoiDungNhap[i] = duLieuMang;

        }
        return mangDoNguoiDungNhap;
    }
}
