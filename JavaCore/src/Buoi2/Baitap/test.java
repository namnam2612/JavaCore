package Buoi2.Baitap;

public class test {
    private void nomKore() {
        System.out.println("day la ham private");
    }

    public void namKorea() {
        System.out.println("day la ham public");
    }

    public static void main(String[] args) {
        test goiHam = new test();
        goiHam.nomKore();
        goiHam.namKorea();
    }
}
