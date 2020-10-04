package hw4;

import java.util.Random;
import java.util.Scanner;

/**
 * This is homework of lesson #4
 * Educational portal "GeekBrains"
 * Geek University Android-development
 *
 * @author Alsado Salim
 */
public class GameXO {
    static final int SIZE = 3;
    static final int CHIPS = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static boolean firstMove = true;
    static int complexity;

    public static void main(String[] args) {
        initComplexity();
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWinChips(DOT_X)) {
                System.out.println("Вы победитель!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();

            if (checkWinChips(DOT_O)) {
                System.out.println("Комьютер победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    /**
     * This method init the complexity of the game.
     */
    static void initComplexity() {
        String msg = "*** Игра Крестики-Нолики ***\n" +
                "Выберете пожалуйста уровень:\n" +
                "1 - Простой, 2 - Сложный";
        System.out.println(msg);
        complexity = sc.nextInt();
    }

    /**
     * This method init the map.
     */
    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * This method print the map of the game.
     */
    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method give human to do a move.
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Input coord X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    /**
     * This method give program to do a move.
     */
    static void aiTurn() {
        if (firstMove) {
            randomCoor();
            firstMove = false;
        } else {
            if (complexity == 1) {
                randomCoor();
            } else if (complexity == 2) {
                if (!tryToWin() && !tryToNotLose()) {
                    randomCoor();
                }
            }
        }
    }

    /**
     * This method give a random coordinates on the map.
     */
    static void randomCoor() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    /**
     * This method check if the cell valid or not.
     * 1.Check if the coordinates is on the map.
     * 2.Check if the coordinates is empty.
     *
     * @param y row index of cell
     * @param x column index of cell
     */
    static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    /**
     * This method check if the map is full.
     */
    static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method check if we have a winner.
     *
     * @param c the symbol of player.
     */
    static boolean checkWinChips(char c) {
        int count;

        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == CHIPS) {
                    return true;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == c) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == CHIPS) {
                    return true;
                }
            }
        }
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == c) {
                count++;
            } else {
                count = 0;
            }
            if (count == CHIPS) {
                return true;
            }
        }

        count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i + j) == (SIZE - 1)) {
                    if (map[i][j] == c) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
            }
            if (count == CHIPS) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method help program to know if next move give a win
     * or not.
     */
    static boolean tryToWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (!checkWinChips(DOT_O)) {
                        map[i][j] = DOT_EMPTY;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method help program to block a human win.
     */
    static boolean tryToNotLose() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (!checkWinChips(DOT_X)) {
                        map[i][j] = DOT_EMPTY;
                    } else {
                        map[i][j] = DOT_O;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
