package Buoi9.BTVN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        // khoi tao danh sach student
        this.students = new ArrayList<Student>();
    }

    /*
    1.	Thêm sinh viên: Người dùng nhập thông tin sinh viên (ID, tên, điểm)
    và hệ thống kiểm tra nếu sinh viên đã tồn tại trong hệ thống (kiểm tra theo ID) để tránh trùng lặp.
    Nếu sinh viên đã tồn tại, hệ thống sẽ ném ra một ngoại lệ.
     */
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------Thong tin cua sinh vien muon them vao------");
        System.out.println("nhap vao id: ");
        String id = sc.nextLine();
        //Kiem tra su ton tai
        Set<String> setId = // set : mot tap hop (collection) trong java, khong cho phep phan tu trung lap
                // <String> kieu du lieu
                this.students // this dung de tham chieu den doi tuong hien tai
                        .stream() // Phương thức stream() chuyển danh sách students (kiểu List<Student>) thành một luồng (stream).
                        //Stream là một API trong Java để xử lý dữ liệu theo phong cách lập trình hàm.
                        .map(Student::getId) // map: một method trong stream api, dùng để chuyển đổi từng phần tử trong luồng giá trị thành một giá trị mới
                        // Student::getId :getId là phương thức được gọi trên từng đối tượng Student để lấy giá trị ID (giả định Student có một phương thức public String getId()).
                        //Kết quả: Tạo một luồng chỉ chứa các giá trị ID (chuỗi String), thay vì các đối tượng Student.
                        .collect(Collectors.toSet()); // collect: Thu thập các phần tử từ luồng và chuyển chúng về một cấu trúc dữ liệu khác.
        // Collectors.toSet(): thu thập cac phan tu trong luong va luu vao mot tap hop (kieu set)
        // vi set khong cho phep phan tu trung lap, bat ki id nao trung lap se bi loai bo
        //  => dòng mã này thu thập tất cả các ID (dạng chuỗi) của sinh viên từ danh sách students và lưu chúng vào một tập hợp setId.
        if (setId.contains(id)) { // xử lý ngoại lệ
            throw new CustomException("id is exits");
        }
        Student student = new Student();
        student.setId(id);
        student.enterInfo();
        this.students.add(student);
        System.out.println("Them hoc sinh thanh cong");
    }
    /*
    2.	Xóa sinh viên: Xóa sinh viên khỏi danh sách dựa trên mã số sinh viên.
    Nếu mã số không tồn tại trong danh sách, hệ thống sẽ ném ra một ngoại lệ.
     */

    public void remove() {
        System.out.println("Nhap id can xoa: ");
        String id = new Scanner(System.in).nextLine();
        // Tim sinh vien
        Student studentRemove = this.students.stream() // bien list student thanh 1 stream
                .filter // loc cac phan tu trong luong dua tren mot dieu kien
                        (student -> student != null && id.equalsIgnoreCase(student.getId())) // tim student voi id
                // student -> student != null : loai bo cac phan tu null khoi luong (dam bao an toan khi xu ly)
                .findFirst() // tra ve phan tu dau tien trong luong (neu ton tai) sau khi ap dung bo loc
                // neu khong co phan tu nao phu hop, tra ve mot gia tri rong (Optional.empty())
                .orElseThrow(() -> new CustomException("Student is not exits"));
        // orElseThrow: xu ly truong hop gia tri rong((Optional.empty()))
        // -> new CustomException("Student is not exits")): lamda expression neu khong tim thay
        // student phu hop, no se nem ra mot ngoai le CustomException voi thong diep tren

        /**
         Kết quả của dòng mã:
         Nếu có Student với ID khớp (không phân biệt hoa thường), biến studentRemove sẽ chứa đối tượng đó.
         Nếu không tìm thấy, một ngoại lệ CustomException với thông điệp "Student is not exits" sẽ được ném ra.
         */

        students.remove(studentRemove);
        System.out.println("Xoa sinh vien thanh cong");
    }

     /*
    3.	Hiển thị danh sách sinh viên: Hiển thị toàn bộ danh sách sinh viên hiện có. Sử dụng ArrayList để lưu trữ danh sách sinh viên.
     */

    public void showAll() {
        this.students.forEach(Student::showInfo); // hien thi danh sach sinh vien, Student::showInfo: method referent
    }

    /*
    4.	Tìm kiếm sinh viên theo tên: Cho phép tìm kiếm sinh viên theo tên. Nếu không tìm thấy sinh viên nào, hệ thống sẽ ném ra một ngoại lệ.
     */
    public void findByname() {
        System.out.println("Nhap ten sinh vien can tim: ");
        String name = new Scanner(System.in).nextLine();
        List<Student> studentsTarget = this.students.stream().filter(student -> student != null && name.equalsIgnoreCase(student.getName()))
                .collect(Collectors.toList());
        if (studentsTarget.isEmpty()) {
            throw new CustomException("Student is empty");
        }
        studentsTarget.forEach(Student::showInfo);
    }

    /*
   5.	Sắp xếp danh sách sinh viên theo điểm thi: Sắp xếp danh sách sinh viên theo điểm thi từ thấp đến cao.
   Nếu danh sách trống, hệ thống sẽ ném ra một ngoại lệ.
    */
    public void sortByPoint() {
        if (this.students.isEmpty()) {
            throw new CustomException("Student is empty");

        }
        List<Student> studentsCopy = new ArrayList<>(this.students);
        studentsCopy.stream()
                .sorted((s1, s2) -> (int) (s1.getPoint() - s2.getPoint()))
                .forEach(Student::showInfo);

    }

    /*
    6.	Kiểm tra sinh viên có tồn tại không: Kiểm tra xem sinh viên có tồn tại trong hệ thống hay không dựa trên mã số sinh viên.
     */
    public void checkExits() {
        System.out.println("Nhap vao id can kiem tra");
        String id = new Scanner(System.in).nextLine();
        // Tim sinh vien
        Student studentTarget = this.students.stream()
                .filter(student -> student != null && id.equalsIgnoreCase(student.getId()))
                .findFirst()
                .orElseThrow(() -> new CustomException("Student is not exits"));
        studentTarget.showInfo();
    }
}
