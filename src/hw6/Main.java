package hw6;

import hw6.animals.Animal;
import hw6.animals.Cat;
import hw6.animals.Dog;
import hw6.animals.Duck;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barzik", "red", 2),
                new Dog("Бобик", "yellow", 3),
                new Dog("Роки", "white", 5),
                new Duck("Утка", "Black", 8),
        };

        for (Animal animal : animals) {
            animal.run(600);
            animal.swim(600);
            animal.fly(1030);
            System.out.println();
        }

        System.out.println("Всего животных: " + Animal.getCountAnimals());
        System.out.println("Всего катов: " + Cat.getCountCats());
        System.out.println("Всего собак: " + Dog.getCountDogs());
        System.out.println("Всего уток: " + Duck.getCountDucks());
    }
}
