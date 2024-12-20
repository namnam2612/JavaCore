package Buoi10.BaiTap;

public class ThreadSum extends Thread {
    private String name;
    private int start;
    private int end;


    public String getname() {
        return name;
    }


    public void setname(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total;

    public ThreadSum(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(this.name + " start");
        for (int i = start; i <= end; i++) {
            this.total += i;

        }
        System.out.println(this.name + " finished");
    }
}
