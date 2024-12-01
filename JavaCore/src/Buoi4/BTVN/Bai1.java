package Buoi4.BTVN;

import java.util.HashMap;
import java.util.Map;

/**
 * Cho chuỗi:
 * Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995.
 * Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó,
 * nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau. Ví dụ: J2EE cho các ứng dụng doanh nghiệp,
 * J2ME cho các ứng dụng di động.
 * <p>
 * a) Đếm số lượng từng từ trong đoạn trên (không phân biệt hoa thường):
 * Ví dụ ta có chuỗi “Tôi học lập trình, học lập trình rất hay”
 * <p>
 * Kết quả từ
 * Tôi : 1 từ
 * Học : 2 từ
 * Lập: 2 từ
 * Trình: 2 từ
 * Rất: 1 từ
 * Hay: 1 từ
 * <p>
 * b. Viết hoa chữ đầu trong mỗi từ
 * <p>
 * c. Xóa các nguyên âm trong câu
 */
public class Bai1 {
    public static void main(String[] args) {
        String chuoi = "Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995. Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó, nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau. Ví dụ: J2EE cho các ứng dụng doanh nghiệp, J2ME cho các ứng dụng di động.";

        System.out.println("a) dem so luong tu:");
        demSoLuongTu(chuoi);


        System.out.println("b) viet hoa chu cai dau moi tu:");
        System.out.println(vietHoaChuCaiDau(chuoi));


        System.out.println("c) xoa cac nguyen am trong cau:");
        System.out.println(xoaNguyenAm(chuoi));


    }

    public static void demSoLuongTu(String chuoi) {
        //loại bỏ các dấu câu và chuyển tất cả về chữ thường
        String chuoiDaXuLy = chuoi.replaceAll("[^a-zA-Zàáạãâầấậẫăằắặẵèéẹẽêềếệễìíịĩòóọõôồốộỗơờớợỡùúụũưừứựữỳýỵỹđ ]", "").toLowerCase();

        //tách các từ
        String[] tu = chuoiDaXuLy.split("\\s+");

        //đếm số lượng từ bằng HashMap
        Map<String, Integer> tuVaSoLuongTu = new HashMap<>();
        for (String t : tu) {
            tuVaSoLuongTu.put(t, tuVaSoLuongTu.getOrDefault(t, 0) + 1);

        }

        //in kết quả

        for (Map.Entry<String, Integer> entry : tuVaSoLuongTu.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " từ");

        }
    }

    public static String vietHoaChuCaiDau(String chuoi) {
        String[] tu = chuoi.split("\\s+");
        StringBuilder ketQua = new StringBuilder();

        for (String t : tu) {
            // viết hoa chữ cái đầu và thêm vào chuỗi kết quả
            if (t.length() > 0) {
                ketQua.append(Character.toUpperCase(t.charAt(0))).append(t.substring(1)).append(" ");
            }
        }
        return ketQua.toString().trim();

    }

    public static String xoaNguyenAm(String chuoi) {
        return chuoi.replaceAll("[aeiouAEIOUàáạãâầấậẫăằắặẵèéẹẽêềếệễìíịĩòóọõôồốộỗơờớợỡùúụũưừứựữỳýỵỹ]", "");

    }

}

