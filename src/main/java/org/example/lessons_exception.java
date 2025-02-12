package org.example;

import java.util.Scanner;

public class lessons_exception {

    public static void main4() {

        try {
            int[] numbers = new int[3];
            numbers[4] = 45;
            System.out.println(numbers[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programm end");
        }

    }

    public static void main5() {

        int[] numbers = new int[3];

        try {
//            numbers[6] = 45;
            numbers[6] = Integer.parseInt("gfd");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования из строки в число");
        } finally {
            System.out.println("Programm end");
        }
    }

    public static void main6() {

        try {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if (x > 30) {
                throw new Exception("Число должно быть меньше 30");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Programm end");
        }
    }

    // Приведение типов не возможно
    public static void main7() {
        Object obj = new String("Hello");
        System.out.println((short) obj);
    }

}
