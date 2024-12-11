package Buoi6.BaiTap;

import java.util.Scanner;

public class ManagerAnimal {

    private Animal[] animals;

    private int currentAnimal;
    private int totalAnimal;

    // khoi tao doi tuong, cac gia tri trong object
    public ManagerAnimal() {
        this.totalAnimal = totalAnimal;
        animals = new Animal[totalAnimal];
    }

    public void addAnimal() {
        System.out.println("nhap vao loai dong vat muon them");
        int type = 0;
        do {
            System.out.println("1: Lion");
            System.out.println("2: Elephant");
            System.out.println("3: Monkey");
            System.out.println("4: dung nhap vap");
            type = new Scanner(System.in).nextInt();
            Animal animal = null;

            switch (type) {
                case 1:
                    animal = new Lion();
                    break;
                case 2:
                    animal = new Elephant();
                    break;
                case 3:
                    animal = new Monkey();
                    break;
                case 4:
                    System.out.println("dung nhap");
                    break;
                default:
                    System.out.println("khong dung dinh dang");
                    type = 1;


            }
            if (animal != null) {
                animal.enterInfor();
                animals[currentAnimal] = animal;
                currentAnimal++;
            }
        } while (type < 4);
    }

    public void showAllAnimal() {
        for (int i = 0; i < currentAnimal; i++) {
            animals[i].showInfo();

        }
    }


}
