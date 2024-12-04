package Buoi4.BTVN;

/**
 * Bài 1
 * Cho chuỗi:
 * Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995. Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó, nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau. Ví dụ: J2EE cho các ứng dụng doanh nghiệp, J2ME cho các ứng dụng di động.
 * a) Đếm số lượng từng từ trong đoạn trên (không phân biệt hoa thường):
 * Ví dụ ta có chuỗi “Tôi học lập trình, học lập trình rất hay”
 * Kết quả từ
 * Tôi : 1 từ
 * Học : 2 từ
 * Lập: 2 từ
 * Trình: 2 từ
 * Rất: 1 từ
 * Hay: 1 từ
 * b. Viết hoa chữ đầu trong mỗi từ
 * c. Xóa các nguyên âm trong câu
 */
public class Bai1V2 {
    public static void main(String[] args) {
        String str = "Tôi học. lập trình, Học; lập trình: rất hay";
        demSoLuongTu(str);
    }

    public static void demSoLuongTu(String str) { //tao ham dem so luong tu
        String[] arrStr = str.split(" "); // xoa cac khoang trang
        //chuan hoa chuoi
        xoaKyTuDacBiet(arrStr); //xoa ky tu o chuoi sau khi xoa cac khoang trang

        //dem so lan xuat hien cac tu
        for (int i = 0; i < arrStr.length; i++) {
            boolean boQuaKyTu = false; // bien boolean tao ra voi gia tri false, dung trong vong lap de quyet dinh xem co bo qua mot ky tu nao do hay khong
            String kyTuKiemTra = arrStr[i]; //gan cac phan tu cua chuoi vao string khoi tao kytukiemtra

            //kiem tra tat ca cac ky tu co index tu 0 toi index = i
            for (int j = 0; j < i; j++) {
                //neu co ky tu nao trung voi tu can kiem tra
                if (kyTuKiemTra.equalsIgnoreCase(arrStr[j])) { //Phương thức equalsIgnoreCase so sánh hai chuỗi (String) với nhau mà không phân biệt chữ hoa và chữ thường. Nó thuộc lớp String.
                    //bo qua tu do = true
                    boQuaKyTu = true;
                    break;

                }
            }
            //bo qua ky tu neu da duoc kiem tra
            if (boQuaKyTu) {
                continue;

            }
            //dem so lan xuat hien tu
            int count = 0;
            for (int j = 0; j < arrStr.length; j++) {
                if (kyTuKiemTra.equalsIgnoreCase(arrStr[j])) {
                    count++;

                }
            }

        }
    }

    public static void xoaKyTuDacBiet(String[] arrStr) {
        for (int i = 0; i < arrStr.length; i++) {
            String str = arrStr[i].replace(".", "").replace(";", "").replace(":", "").replace(",", "").trim(); //xoa cac ky tu dac biet nhu , ; . ...

            arrStr[i] = str; //gan chuoi sau khi xoa cac ky tu dac biet
        }
    }
}