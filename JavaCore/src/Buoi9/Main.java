package Buoi9;

import Buoi8.BaiTap.XayDungAppQuanLyNhanSuCongTy.Employee;

/**
 * Exception:
 * cac loi co the xay ra lam cho gian doan hoac dung chuong trinh, hoac
 * lam cho chuong trinh chay sai khi phat trien chuong trinh java
 * Cac loai loi:
 * + loi trong thoi gian compile time:  -> goi la loi  checked exception
 * vd:
 * sai syntax, thieu thu vien,.....
 * + loi trong thoi diem runtime:  -> goi la loi  unchecked exception
 * + loi say ra trong qua trinh da chay
 * vd: nullpoiter, chia cho 0, truy cap phan tu vuot qua index mang, code sai logic
 * + loi he thong:  -> goi chung la error
 * loi jvm
 * stack overflow: loi do khai bao nhieu bien khien qua tai vung nho stack
 * over heap: khai bao qua nhieu object qua tai vung nho heap
 * ---------------------------------------------------------------------------------------------------------
 * <p>
 * <p>
 * Cách xử lý exception:
 * - try - catch
 * cú phap:
 * try {
 * // code logic devloper du doan co the xay ra loi
 * } catch (ClassException e) {
 * // ClassException: class loi nam trong cay to chuc cua cac exception
 * //code xu ly neu that su co loi say ra
 * }
 */
public class Main {
    public static void main(String[] args) {
        // code khi chua xu ly loi
        /*
        Employee employee = null;
        System.out.println(employee.getMaNV());
        System.out.println("da chay xong chuong trinh");
        */
        // code sau khi duoc xu ly loi su dung try catch


        try {
            Employee employee = null;
            System.out.println(employee.getMaNV());
        } catch (NullPointerException e) {
            System.out.println("da xay ra loi nullpoiter");
        }
        System.out.println("da chay xong chuong trinh");
    }
}
