package Buoi6;

/**
 * tạo ra class con voi với các thuộc tính sau:
 * tên
 * tuổi
 * nơi ở
 * loài cỏ
 * method:
 * diChuyen()
 * hutNuoc();
 * tạo ra class con hổ với các thuộc tính sau
 * tên
 * tuổi
 * nơi ở
 * loài thịt
 * method:
 * diChuyen()
 * sanMoi()
 */
/*
    khi class kế thừa từ class Animal:
    + có tất cả các thuộc tính và method mà class animal có
    + có thể truy cập được các thuộc tính và method với phạm vi truy cập (public, protected,
        default với điều kiện cùng nằm trong môột package)
    - trong java tất cả các class khi được tạo ra từ thư viện hoặc từ dev. Đều mặc định kế thừa
        class object của java
    - this : đại diện cho đối tượng hiện tại, để có thể sử dụng thao tác với (gọi tới) các thuộc tính,
    method khi con trỏ nằm trong class
    - supper: là một biến tham chiếu được sử dụng trong class con (subclass) để có thể thao tác (gọi tới)\
    các thuộc tính hoặc method của lốp cha(superclass) gần nhất với lớp con
 **/

public class Main {
    public static void main(String[] args) {
        AnimalHai animalHai = new AnimalHai();
        animalHai.setTen("Avoi");
        animalHai.diChuyen();

        // sử dụng class cha khởi tạo đối tượng con

        Ho ho = new Ho();
        ho.diChuyen();
        ho.sanMoi();

        voi voi = new voi();
        voi.hutNuoc();
        voi.diChuyen();

        // sử dụng class cha, khởi tạo đối tượng con

        AnimalHai animal = new voi();
        animalHai.diChuyen();

        // instanceof: kiểm tra xem object có phải kiểu của class được chỉ định không (có được tạo ra từ class đó không )
        AnimalHai ho2 = new Ho();
        if (ho2 instanceof Ho) {
            ((Ho) ho2).sanMoi();
        }
        ho2.diChuyen();
    }
}
