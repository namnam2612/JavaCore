package Buoi8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Iterable<Integer> integers;
        Collection collection;
        List<Integer> list;

        // khai báo một tập hợp 10 phần tử số nguyên
        Integer[] arrayInteger = new Integer[10];

        // khai báo 1 tập hợp 10 phần tử số nguyên sử dụng interface list collection

        List<Integer> integers1 = new ArrayList<Integer>();
        // sử dụng các class implemant để khởi tạo đô tượng collection từ interface

        // thêm mới một phần tử vào collection
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        integers1.add(4);

        // kiểm tra số lượng phần tử hiện tại
        System.out.println(integers1.size());
        //cập nhật giá trị phần tử
        integers1.set(1, 10); // cập nhật giá trị tại vị trí index = 1 với giá trị là 10
        // truy cập phần tử trong collection có vị trí index = 1
        Integer data = integers1.get(1);
        System.out.println("data: " + data);
        // kiểm tra phần tử có tồn tại phần tử bằng 1 trong collection hay không
        System.out.println(integers1.contains(1));
        // duyệt danh sách các phần tử trong collection, tương tự duyệt mảng
        for (Integer elemant : integers1) {
            System.out.println(elemant);
        }
        // sử dụng iterator để duyệt danh sách collection
        Iterator<Integer> iterator = integers1.iterator();

        //iterator.hasNext(): kiểm tra nếu vẫn còn phần tử phía sau
        while (iterator.hasNext()) {
            // lấy phần tử phía sau
            Integer dataI = iterator.next();
            System.out.println("lấy phần tử phía sau " + dataI);
        }

        //
        Set<Integer> set = new HashSet<>();
        SortedSet<Integer> sortedSet = new TreeSet<>();
    }
}
