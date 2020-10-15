package hw6.animals;

public abstract class Animal {
    int runDistance;
    int swimDistance;
    int flyDistance;
    private String msg = "";
    private final String name;
    private final String color;
    private final int age;
    private static int countAnimals = 0;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        Animal.countAnimals++;
    }

    public void info() {
        System.out.printf("%s %s %d\n", name, color, age);
    }

    public void run(int distance) {
        if (runDistance == 0) {
            msg = name + " не умееть бегать!";
        } else if (distance > runDistance) {
            msg = name + " смог(ла) пробежать только " + runDistance + " м из " + distance + ".";
        } else {
            msg = name + " пробежал(ла) " + distance + " м.";
        }
        System.out.println(msg);
    }

    public void swim(int distance) {
        if (swimDistance == 0) {
            msg = name + " не умееть плавать!";
        } else if (distance > swimDistance) {
            msg = name + " смог(ла) поплавать только " + swimDistance + " м из " + distance + ".";
        } else {
            msg = name + " поплыл(ла) " + distance + " м.";
        }
        System.out.println(msg);
    }

    public void fly(int distance) {
        if (flyDistance == 0) {
            msg = name + " не умееть летать!";
        } else if (distance > flyDistance) {
            msg = name + " смог(ла) летать только " + flyDistance + " м из " + distance + ".";
        } else {
            msg = name + " плетел(ла) " + distance + " м.";
        }
        System.out.println(msg);
    }

    public static int getCountAnimals() {
        return countAnimals;
    }
}
