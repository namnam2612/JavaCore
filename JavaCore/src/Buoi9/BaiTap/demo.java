package Buoi9.BaiTap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class demo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // thêm các phần tử vào stack
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        // hiển thị cac phần tử
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("size: " + stack.size());
        System.out.println("lay ra phan tu o dinh");
        System.out.println(stack.pop());
        System.out.println("lay phan tu o dinh khong xoa ");
        System.out.println(stack.peek());
        System.out.println("size: " + stack.size());

        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        System.out.println("Hien thi queue");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("size: " + queue.size());
        System.out.println("lay phan tu dau tien ");
        System.out.println(queue.poll());
        System.out.println("size: " + queue.size());
        System.out.println("lay phan tu ra ma khong xoa");
        System.out.println(queue.peek());
        System.out.println("size: " + queue.size());


    }
}
