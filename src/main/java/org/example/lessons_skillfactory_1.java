package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class lessons_skillfactory_1 {

    public static void skillFactroy() {
        int[] les = new int[]{1, 2, 3, 4, 75};
        MaxValue(les);
        MaxTwo(les);
    }

    public static void MaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void MaxTwo(int[] arr) {
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
        System.out.println(one + " : " + two);

    }


    public static void Stack() {
        CustomStack stack = new CustomStack(5);
        stack.push("Java");
        stack.push("Spring");
        stack.push("Microservice");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static void module_3() {
        int var = 7;
        var = var > 10 ? -10 : 10;
        System.out.println(var);

        int sum = 10;
        for (int i = 10; i < 100; i+=10) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void module_3_1() {
        int first, second;
        char operand;
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число:");
        first = sc.nextInt();

        sc.nextLine();

        System.out.println("Введите операнд:");
        operand = sc.nextLine().charAt(0);

        System.out.println("Введите второе число:");
        second = sc.nextInt();

        switch (operand) {
            case '+':
                System.out.println("Результат: " + (first + second));
                break;
            case '-':
                System.out.println("Результат: " + (first - second));
                break;
            case '*':
                System.out.println("Результат: " + (first * second));
                break;
            case '/':
                // Проверяем деление на ноль
                if (second == 0) {
                    System.out.println("Ошибка: деление на ноль!");
                } else {
                    System.out.println("Результат: " + (first / second));
                }
                break;
            default:
                System.out.println("Ошибка: некорректный операнд!");
        }
    }

    public static void module_3_2() {
        for (int i = 2; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void module_3_3(){
        Random rand = new Random();
        int randInt = rand.nextInt(100);
        System.out.println(randInt);
        Scanner sc = new Scanner(System.in);
        int cislo = sc.nextInt();
        while (cislo == randInt) {
            cislo = rand.nextInt(100);
        }

    }
}
