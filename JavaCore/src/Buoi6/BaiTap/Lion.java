package Buoi6.BaiTap;

public class Lion extends Animal {

    public void roar() {
        System.out.println("Lion is roaring");
    }

    @Override
    public void makeSound() {
        System.out.println("Lion is roaring.");

    }

    @Override
    public void eat() {
        System.out.println("Lion Animal is eating");

    }

    @Override
    public void action() {
        System.out.println("the lion is hunting.");
    }

    @Override
    public void showInfo() {
        System.out.println("con su tu 2 tuoi");
    }

    @Override
    public void enterInfor() {
        System.out.println("enter con lion: ");
        // goi toi ham nhap thong tin cua cha
        super.enterInfor();
    }
}
