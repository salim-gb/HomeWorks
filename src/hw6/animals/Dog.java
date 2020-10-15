package hw6.animals;

public class Dog extends Animal {
    private static int countDogs = 0;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        this.runDistance = 500;
        this.swimDistance = 10;
        this.flyDistance = 0;
        countDogs++;
    }

    public static int getCountDogs() {
        return countDogs;
    }
}
