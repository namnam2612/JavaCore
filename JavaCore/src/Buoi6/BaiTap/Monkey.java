package Buoi6.BaiTap;

public class Monkey extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Monkey is chattering");

    }

    @Override
    public void action() {
        System.out.println("the monkey is climbing trees.");

    }
    @Override
    public void showInfo() {
        System.out.println("con khi 4 tuoi");
    }
}