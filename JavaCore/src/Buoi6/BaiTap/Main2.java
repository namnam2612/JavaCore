package Buoi6.BaiTap;

/**
 -đa hình:
        cùng 1 hành động, nhưng có thể thể hiện bằng các hình thái khác nhau
 vd:
        cùng là tiếng kêu nhưng khi object là lion sẽ kêu: lion is roating
        khi là monkey sẽ kêu monkey is chattering
    => đó chính là tính đa hình trong java

    - các thời điểm đa hình:
        + compile time: là thời điểm chương trình biên dịch từ file .java sang file .class,
                        tức là thời điểm compile chương trình
            để đạt được tính đa hình thời điểm này chúng ta sử dụng overload method
        + runtime: là thời điểm máy ảo jvm chạy các file byte code,
                    hay nói các khác chương trình java đang chạy từng dòng lệnh một
            để đạt được tính đa hình thời điểm này chúng ta sử dụng overiding method

        overload method:
            + sảy ra khi 2 hoặc nhiều method cùng chung xuất hiện trong cùng 1 class với các
                đặc tính sau:
                            + trùng tên (bắt buộc)
                            + trùng tham số truyền vào nhưng khác kiểu dữ liệu truyền vào
                            + khác kiểu dữ liệu trả về nhưng cùng kiểu dữ liệu tham số truyền vào
                            nhưng trong danh sách tham số truyền vào có các kiểu dữ liệu khác nhau

        overiding method:
            + sảy ra tại 2 class có mối quan hệ kế thừa
            - khi class con có tồn tại 1 method giống y hệt class cha
                + giống tenem kiểu dữ liệu trả về, tham số truyền vào
            => method tại class con chính là overide method
 */
public class Main2 {
}
