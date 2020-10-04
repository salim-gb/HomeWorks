package hw3;

import java.util.Random;
import java.util.Scanner;

/**
 * This is the first part of homework of lesson #3
 * Educational portal "GeekBrains"
 * Geek University Android-development
 *
 * @author Alsado Salim
 */

public class GuessNumber {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    public static String msg = "";

    public static void main(String[] args) {
        startGame();
    }

    /**
     * Exercise #1
     * <p>
     * The user have to guess the number how computer choose
     *
     */
    public static void startGame() {
        msg = "****** Угадай число ******\n" +
                "Угадай число, это игра, где Вы\n" +
                "должны угадать секретное число \n" +
                "от 0 до 9 выбранный компьютером.\n" +
                "У Вас всего 3 попыти.\n";
        showMsg(msg);
        int x;
        int y;
        int n = 3;
        int count = 0;
        do {
            x = random.nextInt(10);
            do {
                count++;
                System.out.printf("Попытка №%d:\n", count);
                msg = "Введите число от 0 до 9 ";
                y = getValidNum(0, 9, msg);
                if (x == y) {
                    showMsg("Вы выграли!");
                    count = 0;
                    break;
                }
                if (x > y) {
                    msg = count < n ? "Загаданное число больше чем " + y : "";
                } else {
                    msg = count < n ? "Загаданное число меньше чем " + y : "";
                }
                showMsg(msg);
                if (count >= n) {
                    showMsg("Вы проиграли!");
                    count = 0;
                    break;
                }
            } while (true);
            if (suggestToRepeat()) {
                return;
            }
        } while (true);
    }

    /**
     * This method ask the user if he wants to repeat the game.
     * If yes type 1, if no type 0.
     */
    public static boolean suggestToRepeat() {
        int v;
        msg = "Повторить игру еще раз?\nВведите 1 если да и 0 если нет.";
        v = getValidNum(0, 1, msg);
        return v == 0;
    }

    /**
     * This method check if the number valid or not.
     * If number is valid throw it, if not ask the user
     * to enter valid number.
     * @param min The minimum number user can enter.
     * @param max The maximum number user can enter.
     * @param msg The message we show user if the number
     *            not valid.
     * @return We return only the valid number.
     */
    public static int getValidNum(int min, int max, String msg) {
        int a;
        do {
            showMsg(msg);
            a = sc.nextInt();
        } while (a < min || a > max);
        return a;
    }

    /**
     * This method show message to the user.
     * @param msg The message we show user.
     */
    public static void showMsg(String msg) {
        System.out.println(msg);
    }
}
