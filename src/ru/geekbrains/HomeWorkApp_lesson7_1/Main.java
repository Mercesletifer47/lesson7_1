package ru.geekbrains.HomeWorkApp_lesson7_1;
//1. Расширить задачу про котов и тарелки с едой.
//2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
//3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
//6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
import java.util.Scanner;

public class Main {
    private static int TIME = 0;

    public static void main(String[] args) {
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Мурзик", 400);
        cat[1] = new Cat("Машка", 400);
        cat[2] = new Cat("Дашка", 30);
        Plate plate = new Plate(400);
        System.out.println("Привет! У Вас есть три кота: " + cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() + ", которые хотят есть");
        System.out.println("Кто-то из них более прожорлив, кто-то менее. Сейчас в миске " + plate.getFood() + " грамм кошачьего корма. В данный момент коты очень голодны и направляются трапезничать.\n");
            for (Cat i : cat) {
                //если кот голоден
                if (i.getSatiety() == 0) {
                    //если в миске не хватает еды, чтобы накормить кота, она будет добавлена
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }
                    //кот ест
                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " граммов корма");
                }
            }
    }
}
    class Plate {
        private int food;
        int getFood() {
            return food;
        }
        Plate(int food) {
            this.food = food;
        }
        void decreaseFood(int n) {
            food -= n;
        }
        void increaseFood() {
            this.food += 400;
            System.out.println("В миску добавили 400 грамм корма");
        }
        boolean checkFood(int n) {
            return (food - n) >= 0;
        }
    }

    class Cat {
        private String name;
        private int appetite;
        private int satiety;

        String getName() {
            return name;
        }
        int getAppetite() {
            return appetite;
        }

        int getSatiety() {
            return satiety;
        }

        void setSatiety(int satiety) {
            this.satiety = satiety;
        }

        Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
            this.satiety = 0;
        }

        void eat(Plate p) {
            p.decreaseFood(appetite);
        }
    }


