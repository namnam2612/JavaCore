package Buoi10.BaiTap;

public class Bai1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread start");
        int n = 10;
        ThreadSum thread1 = new ThreadSum("thread1", 1, 5);
        ThreadSum thread2 = new ThreadSum("thread2", 6, 10);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int total = thread1.getTotal() + thread2.getTotal();

        System.out.println("total: " + total);
        System.out.println("");

    }
}
