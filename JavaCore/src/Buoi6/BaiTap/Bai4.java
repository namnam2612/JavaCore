package Buoi6.BaiTap;

public class Bai4 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        Animal lion = new Lion();
        animals[0] = lion;

        Animal voi = new Elephant();
        animals[1] = voi;

        Animal khi = new Monkey();
        animals[2] = khi;

        for (Animal animal : animals) {
            animal.showInfo();
        }
        }
    }

