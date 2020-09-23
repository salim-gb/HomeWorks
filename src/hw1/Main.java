package hw1;

public class Main {
    public static void main(String[] args) {
        byte b = 120;
        short s = 3404;
        int i = 49282;
        long l = 928323823;
        float f = 22.32f;
        double d = 235345345.98938;
        char c = 'd';
        boolean bl = true;
        String st = "GeekBrains";

        System.out.println(checkSum(5, 15));
        checkNum(0);
        System.out.println(isNegative(44));
        printString("Салим");
        checkLeap(2020);
    }

    static int getResult(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    static boolean checkSum(int a, int b) {
        int s = a + b;
        return s >= 10 && s <= 20;
    }

    static void checkNum(int a) {
        String s = a >= 0 ? "Число положительное" : "Число отрицательное";
        System.out.println(s);
    }

    static boolean isNegative(int a) {
        return a < 0;
    }

    static void printString(String s) {
        System.out.println("Привет, " + s);
    }

    static void checkLeap(int a) {
        if (a == 0) {
            System.out.println("Введите правильный формат года!");
            return;
        }
        String s = (a % 4 == 0 && a % 100 != 0) || a % 400 == 0 ?
                "Этот год високосный" : "Этот год не високосный";
        System.out.println(s);
    }
}
