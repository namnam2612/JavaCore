package buoi1;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {

        System.out.println("nhap vao so thu nhat : ");
        int numberOne = new Scanner(System.in).nextInt();

        System.out.println("nhap vao so thu hai : ");
        int numberTwo = new Scanner(System.in).nextInt();

        System.out.println("tong = " + (numberOne + numberTwo));
        System.out.println("tich =  " + (numberOne * numberTwo));
        System.out.println("thuong =  " + (numberOne / numberTwo));
        System.out.println("so du cua thuong =  " + (numberOne % numberTwo));
    }
}
