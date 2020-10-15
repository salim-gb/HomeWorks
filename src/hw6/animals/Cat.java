package hw6.animals;

public class Cat extends Animal {
    private static int countCats = 0;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        this.runDistance = 200;
        this.swimDistance = 0;
        this.flyDistance = 0;
        countCats++;
    }

    public static int getCountCats() {
        return countCats;
    }
}
