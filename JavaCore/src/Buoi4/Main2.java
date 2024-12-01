package Buoi4;

/**
  String:
       + là một class đặc bệt được cung cấp sẵn bởi
         jdk, chuyên xử lý về chuỗi ký tự
       + bất biến, không thể thay đổi
  có 2 kiu khai báo:
       + khai báo theo kiểu nguyên thủy:
           string sẽ được lưu trong string pool, và không tồn tại
           2 string giống nhau trong string pool
       + khai báo theo kiểu đối tượng:
           string nằm trong object String trong heap
  so sánh string:
       +sử dụng ==
           - nếu là đối tượng:
                so sánh địa chỉ ô nhớ của object trong heap
           - nếu là kểu nguyên thủy:
                so sánh giá trị của 2 biến trong stack
        + sử dụng equal
           chỉ áp dụng cho các biến đối tượng
           sẽ sử dụng để so sánh value 2 biến
        => nên sử dụng equal để so sánh hai string

 -coi một chuỗi text trong string như là một mảng các
 ký tự

 */
public class Main2 {
    public static void main(String[] args) {
        String text = "hello";
        String text2 = "hello";
        String text3 = new String("hello");

        System.out.println(text == text2);
        System.out.println(text.equals(text2));
        System.out.println(text.equals(text3));
        System.out.println(text == text3); // so sánh 2 biến có 2 địa chỉ khác nhau

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello").append(" world");
        System.out.println(stringBuilder.toString()); // gọi hàm toString mới tạo ra chuỗi


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello").append(" world!");
        System.out.println(stringBuffer.toString());

        /*
        char[]
        tại sao StringBuilder và StringBuffer có thể tạo ra các string có thể thay đổi ?

        đồng bộ: các câu lệnh và quá trình xử lý của một chương trình sẽ diễn ra tuần tự từ trên xuống dưới
                    với một luồng nhất định, các câu lệnh chỉ chạy trên một luồng chính và phải chờ giải phóng tài nguyên
                        mới đươc sử dụng

        StringBuffer:
            hoạt động theo cơ chế đồng bộ, luồng an toàn

        StringBuilder:
            hoạt động theo cơ chế bất đồng bộ, luồng không an toàn
        */


    }
}
