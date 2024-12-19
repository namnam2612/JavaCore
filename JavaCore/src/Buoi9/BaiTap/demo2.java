package Buoi9.BaiTap;

import java.util.*;

public class demo2 {
    public static void main(String[] args) {
        // set chỉ chứa cac phần tử duy nhất, không trùng lặp
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        System.out.println("size: " + set.size());
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("Map: tap hop cac entry, moi entry co 2 thanh phan: key - value ");
        Map<Integer, String> mapIdName = new HashMap<Integer, String>(); // tao ra 1 map co key kieu du lieu interger, value : kieu du lieu string

        // them phan tu vao map
        mapIdName.put(1, "nam");
        mapIdName.put(2, "yeu");
        mapIdName.put(3, "cac");
        mapIdName.put(4, "em");
        //truy cap phan tu cua map
        System.out.println("truy cap phan tu cua map, sd key, vd key = 1, value = " + mapIdName.get(1));

        System.out.println("duyet map su dung entry: ");
        for (Map.Entry<Integer, String> entry : mapIdName.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        Map<Integer, String> mapHashTable = new Hashtable<>();

        // <String>: generi (tham số, kiểu dữ liệu truyền vào)

        ListDemo<String> listDemo = new ArrayListDemo<>();
        listDemo.add("1");
        System.out.println("Lay ra phan tu: " + listDemo.get(0));

    }
}
