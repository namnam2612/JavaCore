package Buoi6.BaiTap;

public class Elephant extends Animal {

    public void trumpet() {
        System.out.println("Elephant is trumpeting");
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant is trumpeting.");

    }

    @Override
    public void eat() {
        System.out.println("Elephant Animal is eating");

    }

    @Override
    public void action() {
        System.out.println("the elephant is spraying water.");
    }

    @Override
    public void showInfo() {
        System.out.println("info voi la:");
        super.showInfo();
    }

    @Override
    public void enterInfor() {
        System.out.println("enter con voi: ");
        // goi toi ham nhap thong tin cua cha
        super.enterInfor();
    }
}
