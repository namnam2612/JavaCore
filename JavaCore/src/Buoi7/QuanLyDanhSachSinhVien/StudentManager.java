package Buoi7.QuanLyDanhSachSinhVien;

import java.util.Scanner;

public class StudentManager extends Student {

    private Student[] students = new Student[10];
    private int size = 0;
    private Scanner sc = new Scanner(System.in);

    public StudentManager() {
        super("", 0, ""); // Gọi constructor của lớp cha với giá trị mặc định
    }


    private void moRongMang() {
        Student[] newStudents = new Student[students.length * 2];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];

        }
        students = newStudents;
    }


    public void themSV() {
        if (size == students.length) {
            moRongMang();
        }
        System.out.println("Nhap thong tin sinh vien(ten, tuoi, ma sinh vien: )");
        String name = sc.nextLine();
        int age = sc.nextInt();
        sc.nextLine();
        String msv = sc.nextLine();

        for (int i = 0; i < size; i++) {
            if (students[i].getMsv().equalsIgnoreCase(msv)) {  // so sánh mã sinh viên mới với mã sinh viên đã tồn tại trong mảng
                System.out.println("Ma sinh vien da ton tai !");
                return;
            }

        }
        students[size++] = new Student(name, age, msv);
        System.out.println("Thong tin sinh vien da duoc ghi nhan");
    }

    public void editSV() {
        System.out.println("Dien ma sinh vien can can chinh sua");
        String msv = sc.nextLine();

        for (int i = 0; i < size; i++) {
            if (students[i].getMsv().equalsIgnoreCase(msv)) {
                System.out.println("Thong tin sinh vien hien tai");
                System.out.println(students[i]);

                System.out.println("edit ten ");
                String newName = sc.nextLine();
                System.out.println("edit tuoi ");
                int newAge = sc.nextInt();
                sc.nextLine();
                System.out.println("edit msv ");
                String newMSV = sc.nextLine();

                students[i].setName(newName);
                students[i].setAge(newAge);
                students[i].setMsv(newMSV);

                System.out.println("Thong tin sinh vien da duoc cap nhat");
                return;
            }
            System.out.println("Khong tim thay msv " + msv + " trong he thong");
        }
    }

    public void xoaSV() { //
        System.out.println("Nhap ma sinh vien can xoa: ");
        String msv = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (students[i].getMsv().equalsIgnoreCase(msv)) {
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[i--] = null;
                size--;
                found = true;
                System.out.println("sinh vien da duoc xoa khoi danh sach");
                break;
            }

        }
        if (msv == null) {
            System.out.println("Khong tim thay msv " + msv + " trong he thong");
        }
    }

    public void searchSV() {
        System.out.println("Nhap ten sinh vien can tim: ");
        String name = sc.nextLine();
        boolean found = true;

        for (int i = 0; i < size; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Khong tim thay sinh vien " + name + " trong danh sach !");
        }
    }

    public void hienThiDanhSachSinhVien() {
        if (size == 0) {
            System.out.println("Danh sach sinh vien trong! ");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(students[i]);
            }
        }
    }

    public void Menu() {
        Scanner sc = new Scanner(System.in);

        boolean choice = true;
        do {
            System.out.println("<<-------------CHON CHUONG TRINH------------->>");
            System.out.println("<<     1. Them sinh vien vao danh sach       >>");
            System.out.println("<<     2. Sua thong tin sinh vien            >>");
            System.out.println("<<     3. Xoa sinh vien khoi danh sach       >>");
            System.out.println("<<     4. Tim kiem sinh vien theo ten        >>");
            System.out.println("<<     5. Hien thi danh sach sinh vien       >>");
            System.out.println("<<     6. Thoat                              >>");
            System.out.println("<<___________________________________________>>");

            System.out.println("Nhap lua chon cua ban");
            int luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    themSV();
                    break;
                case 2:
                    editSV();
                    break;
                case 3:
                    xoaSV();
                    break;
                case 4:
                    searchSV();
                    break;
                case 5:
                    hienThiDanhSachSinhVien();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh");
                    choice = false;
                    break;

                default:
                    System.out.println("Lua chon khong hop le");

            }
        } while (choice);
    }


}
