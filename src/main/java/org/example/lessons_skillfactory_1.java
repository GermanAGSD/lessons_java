package org.example;

import java.util.*;

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
        for (int i = 10; i < 100; i += 10) {
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

    public static void module_3_3() {
        Random rand = new Random();
        int randInt = rand.nextInt(100);
        System.out.println(randInt);
        Scanner sc = new Scanner(System.in);
        int cislo = sc.nextInt();
        while (cislo == randInt) {
            cislo = rand.nextInt(100);
        }

    }

    public static void module_4() {
        int[] arr = {13, 32, 39, 4, 55, 36, 7, 82, 99, 10};
        int[] copy = arr;
        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i] * 2;
            System.out.println(copy[i]);
        }
    }

    public static void module_4_1() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
        };

        // Копирование массива полностью
        int[] arr2 = {22, 4, 5, 6};
        int[] copy2 = Arrays.copyOf(arr2, arr2.length);
        System.out.println(copy2[0]);

        // копирует часть массива
        int[] copy3 = Arrays.copyOfRange(arr2, 1, 3);
        System.out.println(copy3[0]);

        // Вывести массив в строку
        System.out.println(Arrays.toString(copy3));

        // Сортировка массива
        Arrays.sort(copy3);
        System.out.println(Arrays.toString(copy3));

        // Поиск индекса элемента метод Бинарный
        System.out.println(Arrays.binarySearch(arr2, 4));

        // Заполнить массив определенным значением
        Arrays.fill(arr2, 5);
        System.out.println(Arrays.toString(arr2));

        // Проверка равны ли массивы
        int[] mass = {2, 4, 6};
        int[] mass2 = {2, 4, 6};

        System.out.println(Arrays.equals(mass, mass2));
    }
    public static void module_4_2(){
        String name = "German";
        String name2 = "German";
        System.out.println(name.length());
        System.out.println(name.charAt(0));
        System.out.println(name.equalsIgnoreCase(name2));

        String str = "Java";
        StringBuffer strBuffer = new StringBuffer(str);

        System.out.println("Емкость: " + strBuffer.capacity());
        strBuffer.ensureCapacity(32); // увеличиваем резервируемую емкость символов
        System.out.println("Емкость: " + strBuffer.capacity());
        System.out.println("Длина: " + strBuffer.length());

        char c = strBuffer.charAt(0); // Извлекаем первую букву
        strBuffer.setCharAt(0,'c'); // Вставляем на позицию сивмол
        System.out.println(strBuffer); // cava
        System.out.println(str.trim());
    }

    public static void module_4_3() {
        Scanner sc = new Scanner(System.in);
        boolean isCorrectName = false;
        while(!isCorrectName) {
            String name = sc.nextLine();
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Должно быть 3 слова");
            }else{
                System.out.println(formatName(name));
            }
        }
    }

    // Нужно использовать split("\\s+"), так как пробел является разделителем слов.
    private static boolean checkName(String name) {
        return name.trim().split("\\s+").length == 3;
    }

    private static String formatName(String name) {
        // Разбиваем строку на слова
        String[] words = name.trim().split("\\s+");

        // Сортируем по длине
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Делаем каждое слово с заглавной буквы
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        // Собираем обратно в строку
        return String.join(" ", words);
    }
}
