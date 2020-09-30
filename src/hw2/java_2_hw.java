package hw2;

import java.util.Arrays;

/**
 * This is the homework of lesson #2
 * Educational portal "GeekBrains"
 * Geek University Android-development
 *
 * @author Alsado Salim
 */

public class java_2_hw {
    public static void main(String[] args) {
        int[] arr1 = {1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0};
        replaceNum(arr1);
        int[] arr2 = new int[8];
        fillArray(arr2, 3);
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyNum(arr3, 6, 2);
        int[][] arr4 = new int[4][4];
        fillArrDiagonals(arr4, 1);
        int[] arr5 = {-20, 2, 7, 22, 99, 25, 40, 120, 70};
        findMin(arr5);
        findMax(arr5);
        int[] arr6 = {1, 4, 5, 0, 1, 3, 2, 2, 2, 1};
        System.out.println(checkBalance(arr6));
        int[] arr7 = {1, 2, 3, 9, 5, 7};
        shiftElements(arr7, -2);
    }

    /**
     * Exercise #1
     * <p>
     * This method replace the elements with it each other of the array
     * consisting of 0 and 1
     *
     * @param array Array that is the source of integer numbers
     */
    public static void replaceNum(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Exercise #2
     * <p>
     * This method fill empty array with integer numbers in arithmetic
     * progression number n
     *
     * @param array Empty integer array
     * @param n     The number with which we sum the array elements
     */
    public static void fillArray(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * n;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Exercise #3
     * <p>
     * This method check if element of array less than m,
     * if true multiply by n
     *
     * @param array Given array with Integer number
     * @param m     The number with which we will compare
     * @param n     The number by which we will multiply
     */
    public static void multiplyNum(int[] array, int m, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < m) {
                array[i] *= n;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Exercise #4.1
     * <p>
     * This method fill primary diagonal elements of array with number n
     *
     * @param array Two-dimensional empty integer array
     * @param n     Number with which to fill diagonal
     */
    public static void fillArrDiagonal(int[][] array, int n) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][i] = n;
                }
                System.out.printf("%4s", array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Exercise #4.2
     * <p>
     * This method fill primary and secondary diagonal elements of array
     * with number n
     *
     * @param array Two-dimensional empty integer array
     * @param n     Number with which to fill diagonals
     */
    public static void fillArrDiagonals(int[][] array, int n) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i == j) || (i + j == array.length - 1)) {
                    array[i][j] = 1;
                }
                System.out.printf("%4s", array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Exercise #5.1
     * <p>
     * This method find min element in integer array
     *
     * @param array Array of integer numbers
     */
    public static void findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.printf("Min = %d\n", min);
    }

    /**
     * Exercise #5.2
     * <p>
     * This method find max element in integer array
     *
     * @param array Array of integer numbers
     */
    public static void findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.printf("Max = %d\n", max);
    }

    /**
     * Exercise #6.1
     * <p>
     * This method check if there is a place in the array where
     * the sum of the left and right side of the array is equal.
     *
     * @param array Array of integer numbers
     */
    public static boolean checkBalance(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < array.length - 1; i++) {
            sumLeft += array[i];
            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
            }
            if (sumLeft == sumRight) {
                return true;
            }
            sumRight = 0;
        }
        return false;
    }

    /**
     * Тут хотел узнать Ваше мнение по поводу производительность
     * кода в случае если почитать сумму всех елементов один раз.
     * <p>
     * Exercise #6.2
     * <p>
     * This method check if there is a place in the array where
     * the sum of the left and right side of the array is equal.
     *
     * @param array Array of integer numbers
     */
    public static boolean checkBalance_(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int k : array) {
            sumRight += k;
        }
        for (int i = 0; i < array.length - 1; i++) {
            sumLeft += array[i];
            sumRight -= array[i];
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    /**
     * Exerciser #7.1
     * <p>
     * This method should shift all elements of the array by n
     * positions.
     * <p>
     *@param array Array of integer numbers
     *@param n     Number of positions that the array should shift.
     */
    public static void shiftElements(int[] array, int n) {
        int f = n < 0 ? -(n) : n;
        int lastIndex = array.length - 1;
        int temp;
        for (int j = 0; j < f; j++) {
            if (n > 0) {
                temp = array[lastIndex];
                for (int i = lastIndex; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = temp;
            } else if (n < 0) {
                temp = array[0];
                for (int i = 0; i < lastIndex; i++) {
                    array[i] = array[i +1];
                }
                array[lastIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Exerciser #7.2
     * <p>
     * This method should shift all elements of the array by n
     * positions.
     * <p>
     *@param array Array of integer numbers
     *@param n     Number of positions that the array should shift.
     */
    public static void shiftElementsN(int[] array, int n) {
        int m = n < 0 ? array.length - 1 : 0;
        int s = n > 0 ? array.length - 1 : 0;
        int f = n < 0 ? -(n) : n;
        int temp;
        for (int j = 0; j < f; j++) {
            temp = array[s];
            for (int i = s; i != m; i -= n / f) {
                array[i] = array[i - (n / f)];
            }
            array[m] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
