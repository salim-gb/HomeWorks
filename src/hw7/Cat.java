package hw7;

import java.util.Random;

public class Cat {
    static Random random = new Random();
    private String name;
    private boolean satiety = false;
    private int required_food = random.nextInt(20) + 20; // У каждого кота есть свой аппетит

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {
        if (required_food <= plate.getFood()) {
            satiety = true;
            plate.decreaseFood(required_food);
        }
    }

    public String getName() {
        return name;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public int getRequired_food() {
        return required_food;
    }
}
