package hw7;

public class Plate {
    private int food;

    public void decreaseFood(int amount) {
        if (amount < 0) {
            return;
        }
        food -= amount;
    }

    public String addFood() {
        if (food < 100) {
            this.food = 100;
            return "Тарелка наполнена";
        }
        return "<html>Тарела полная,<br>пока не можете<br>добавить еды!</html>";
    }

    public int getFood() {
        return food;
    }
}
