package hw3;

import java.util.Random;
import java.util.Scanner;

/**
 * This is the second part of homework of lesson #3
 * Educational portal "GeekBrains"
 * Geek University Android-development
 *
 * @author Alsado Salim
 */

public class GuessWord {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        guessWord();
    }

    /**
     * Exercise #2
     * The user have to guess the word how computer choose.
     */
    public static void guessWord() {
        StringBuilder m = new StringBuilder();
        int count = 0;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String msg = "****** Угадай слово ******\n" +
                "Угадай слово, это игра, где Вы\n" +
                "должны угадать названия фрукта\n" +
                "или овощ загаданного компьютером.\n";
        System.out.println(msg);

        int x = random.nextInt(words.length);
        String s1 = words[x];
        do {
            m.setLength(0);
            msg = count == 0? "Введите слово:" : "Попробуйте еще раз:";
            System.out.println(msg);
            String s2 = sc.next();
            if (s1.equals(s2)) {
                System.out.printf("**** Молодцы ****\nВы угадали слово c %s попытки!", count);
                return;
            }
            int d = Math.min(s1.length(), s2.length());
            for (int i = 0; i < d; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    m.append(s1.charAt(i));
                } else {
                    m.append("#");
                }
            }
            System.out.println(String.format("%-15s", m).replace(' ', '#'));
            count++;
        } while (true);
    }
}
