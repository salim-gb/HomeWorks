package hw6.animals;

public class Duck extends Animal {
    private static int countDucks= 0;

    public Duck(String name, String color, int age) {
        super(name, color, age);
        this.runDistance = 30;
        this.swimDistance = 200;
        this.flyDistance = 950;
        countDucks++;
    }

    public static int getCountDucks() {
        return countDucks;
    }
}
