package org.example;

public class lessons_1 {

    public static void main2() {
        int a = 1, b = 2;
        int res = a + b;
        System.out.println(res);

        int[] arr = {15, 27, 3, 344, 17};
        int summ = 0;
        for (int i : arr) {
            summ += i;
        }
        System.out.println(summ / arr.length);


        Integer a2 = 130;
        Integer a3 = 130;
        System.out.println(a2 == a3);
    }

    // Найти максимальный элемент в массиве
    public static void main3() {
        int[] array = new int[]{64, 42, 73, 43, 65, 78, 56, 76, 32, 1, 3, 4, 54};
        printMax(array);
        printDoubleSummMan(array);
    }

    public static void printMax(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Массив пустой");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    // Найти два максимальных числа
    public static void printDoubleSummMan(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать минимум два элемента");
        }
        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > one) {
                two = one;
                one = arr[i];
            } else if (arr[i] > two) {
                two = arr[i];
            }
        }
        System.out.println(one + " " + two);
    }
}

