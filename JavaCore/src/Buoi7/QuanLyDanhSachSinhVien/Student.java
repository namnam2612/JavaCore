package Buoi7.QuanLyDanhSachSinhVien;

public class Student {
    private String name;
    private int age;
    private String msv;

    public Student(String name, int age, String msv) {
        this.name = name;
        this.age = age;
        this.msv = msv;
    }

    public void student(String name, int age, String msv) {

        this.name = name;
        this.age = age;
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "msv " + msv + ", ten: " + name + ", tuoi: " + age;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public Student() {

    }


}
