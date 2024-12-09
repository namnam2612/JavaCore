package Buoi6.BaiTap;

public class Bai2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        Animal lion = new Lion();
        Animal voi = new Elephant();
        Animal khi = new Monkey();

        animals[0] = lion;
        animals[1] = voi;
        animals[2] = khi;

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
