package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.reactivex.rxjava3.core.*;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class lessons_skillfactory_1 {

    public static void skillFactroy() {
        int[] les = new int[]{1, 2, 3, 4, 75};
        int[] arr = new int[]{12, 3, 1, 2};
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
        System.out.println(arr.length);
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
        int[] arr = new int[]{13, 32, 39, 4, 55, 36, 7, 82, 99, 10};
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
        System.out.println(Arrays.toString(copy2));

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

    public static void module_4_2() {
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
        strBuffer.setCharAt(0, 'c'); // Вставляем на позицию сивмол
        System.out.println(strBuffer); // cava
        System.out.println(str.trim());
    }

    public static void module_4_3() {
        Scanner sc = new Scanner(System.in);
        boolean isCorrectName = false;
        while (!isCorrectName) {
            String name = sc.nextLine();
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Должно быть 3 слова");
            } else {
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
        System.out.println(words.length);
        // Делаем каждое слово с заглавной буквы
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        // Собираем обратно в строку
        return String.join(" ", words);
    }

    public static void module_4_4() {
        int[] arr1 = {5, 24, 3, 66, 38, 16, 27};
        System.out.println(arr1[3]);

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        String name = sc.nextLine();
        System.out.println("Создайте пароль:");
        String PW = sc.nextLine();
        if (PW.length() < 8 || PW.length() > 15) {
            do {
                System.out.println("Длина пароля должна составлять от 8 до 15 символов");
                PW = sc.nextLine();
            } while (PW.length() < 8 || PW.length() > 15);
        }
        System.out.printf("%s, Ваш новый пароль: %s", name, PW);

    }

    public static void module_4_5() {
        int i, j;
        String[] result = new String[5];
        int[][] points = {
                {4, 3, 2, 5, 1},
                {3, 4, 4, 6, 2},
                {2, 5, 4, 3, 2},
                {8, 4, 2, 0, 4},
                {4, 4, 3, 2, 9},
        };

        int[] sumPoints = new int[5];
        String[] names = {"Alex", "Igor", "Michael", "Nicolay", "Vladimir"};
        for (int k = 0; k < names.length; k++) {
            for (int l = 0; l < points[k].length; l++) {
                sumPoints[l] += points[k][l];
            }
            result[k] = names[k] + " " + sumPoints[k];
            System.out.println(result[k]);
        }
    }

    public static boolean checkBook(Book[] bookList, Book book) {
        for (Book item : bookList) {
            if (item != null && item.name.equals(book.name) && item.date == book.date) {
                System.out.println("Данная книга уже есть в картотеке");
                return true;
            }
        }
        System.out.println("Данной книги нет");
        return false;
    }

    public static void addBook(Book[] bookList, Book book) {
        if (!checkBook(bookList, book)) {
            for (int i = 0; i < bookList.length; i++) {
                if (bookList[i] == null) {
                    bookList[i] = book;
                    System.out.println("Книга добавлена в картотеку");
                    break;
                }
                if (i == bookList.length - 1) {
                    System.out.println("Картотека переполнена");
                }
            }
        }
    }

    public static void printAllBookList(Book[] bookList) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null) {
                System.out.println(bookList[i].name + " " + bookList[i].date + " " + bookList[i].price);
            }
        }
    }

    public static void module_4_6() {
        Book[] bookList = new Book[99];
        Book book1 = new Book("The Hobbits", 1000, 1996);
        addBook(bookList, book1);
        printAllBookList(bookList);
    }

    public static void module_4_7() {
        double[] arr = new double[]{1.3, 3.2, 5.1, 4.7};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        double total = 0;
        for (int j = 0; j < arr.length; j++) {
            total += arr[j];
        }
        System.out.println(total);

        double max = Double.MIN_VALUE;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] > max) {
                max = arr[k];
            }
        }
        System.out.println(max);
    }

    public static void module_4_8() {
        String original = "German Hello";
        String reverse = new StringBuilder(original).reverse().toString();
        System.out.println(reverse);
        StringBuffer sb = new StringBuffer(original);
        System.out.println(sb.toString());
    }

    public static String[] split3(String str) {
        return str.trim().split("\\s+");
    }

    public static void module_4_9() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 9);
        System.out.println(index);

        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Pear");
        System.out.println(list);


        ArrayList<Map<Integer, String>> list1 = new ArrayList<>();
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Apple");
        map1.put(2, "Banana");
        map1.put(3, "Orange");
        map1.put(4, "Pear");

        list1.add(map1);
        System.out.println(map1);
        // Сортировка по минимальному ключу в каждой карте

        System.out.println(list1);
    }

    public static String upperTo(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static void name() {
        String name = "german";
        String nameUpper = upperTo(name);
        System.out.println(nameUpper);
    }

    public static void module_4_10() {
        System.out.println(upperTo("German"));
        System.out.println(pochoviYashik("german@gmail.com"));
    }

    public static String pochoviYashik(String post) {
        int indexSobaka = post.indexOf("@");
        System.out.println(indexSobaka);
        String pochtoviYashik = post.substring(indexSobaka + 1); // gmail.com
        return pochtoviYashik;
    }

    public static void module_4_11() {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i % 2 == 0) ? (i + 1) : -(i + 1);
        }
        System.out.println(Arrays.toString(numbers));
        fibonachi();
    }

    public static void fibonachi() {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0 || i == 1) {
                numbers[0] = 1;
                numbers[1] = 1;
            } else {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static void module_4_12() {
        System.out.println(Math.abs(-10));      // 10 (модуль числа)
        System.out.println(Math.pow(2, 3));     // 8.0 (2 в степени 3)
        System.out.println(Math.sqrt(16));      // 4.0 (квадратный корень)
        System.out.println(Math.max(5, 10));    // 10 (максимум)
        System.out.println(Math.min(5, 10));    // 5 (минимум)
        System.out.println(Math.round(4.6));    // 5 (округление)
        System.out.println(Math.floor(4.9));    // 4.0 (округление вниз)
        System.out.println(Math.ceil(4.1));     // 5.0 (округление вверх)
        System.out.println(Math.random());      // случайное число от 0.0 до 1.0
    }

    public static void module_4_13() {
        int size = 5; // Размер треугольника (больше 2)
        int[][] ints = new int[size][]; // Зубчатый массив

        // Заполняем массив
        for (int i = 0; i < size; i++) {
            ints[i] = new int[i + 1]; // Длина строки = i + 1
            ints[i][0] = 1;           // Первый элемент всегда 1
            ints[i][i] = 1;           // Последний элемент всегда 1

            for (int j = 1; j < i; j++) {
                ints[i][j] = ints[i - 1][j - 1] + ints[i - 1][j]; // Заполняем сумму двух верхних элементов
            }
        }

        // Выводим массив
        for (int[] row : ints) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void module_4_14() {
        int size = 4;
        String[][] board = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = (char) ('A' + j) + String.valueOf(size - i);
            }
        }

        // Выводим доску
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void module_4_15() {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();
        Tank tank3 = new Tank();
        tank1.printPosition();
        tank2.printPosition();
        tank3.printPosition();
    }

    //    Регулярные выражения
    public static void module_4_16() {
        String textFromLogsFile = "WrongMsisdnError SuccessfulTransaction TimeOutError InternalError SuccessfulTransaction ExternalIDError SuccessfulTransaction WrongIDError InvalidArgumentError SuccessfulTransaction SuccessfulTransaction SuccessfulTransaction WrongMsisdnError";
        String[] str = textFromLogsFile.split(" ");
        for (String s : str) {
            if (Pattern.matches(".*?Error", s)) {
                System.out.println(s + " ");
            }
        }
    }

    public static void module_4_17() {
        String text = "Рекс Лорд Лом Шарик Бобик Шалун";
        Pattern pattern = Pattern.compile("\\b[Л][а-я]+\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }

    public static void sort() {
        String[] array = {"баркас", "елка", "баржа", "арбузы", "тыква"};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortlength() {
        String[] array = {"баркас", "елка", "баржа", "арбузы", "тыква"};
        ComparatorByLength comp = new ComparatorByLength();
        Arrays.sort(array, comp);

        for (String word : array) {
            System.out.println(word);
        }
    }

    public static void jframeTest() {
        JFrame jr = new JFrame();
        jr.setSize(300, 400);
        jr.addMouseListener(new SimpleClickListener());
        jr.setVisible(true);

    }

    public static void MouseBoard() {
        MotherBoard mb = new MotherBoard();
        System.out.println("Total Ports = " + mb.usb.getTotalPorts());
        System.out.println(MotherBoard.USB.wikilink);

//        MotherBoard.USB usb = MotherBoard.USB(10000, 20500) // разъемов в сутки
    }

    public static void remoteTv() {
        TVset tv = new TVset();
        TVset.Remote rem = tv.getRemote();
        rem.turnOn();
        System.out.println(tv.toString());
        rem.setChannel(10);
        System.out.println(tv.toString());
        int c = 5;
        int n = (short) c;
        System.out.println();
    }

    public static void libr() {
        int c = 5;
        int d = 3;
        var i = Math.pow(c, d);
        System.out.println(i);
    }

    public static void libr_2() {
        Date date = new Date();
        System.out.println(date);

        long time = System.currentTimeMillis();
        System.out.println(time);

        Calendar calendar = Calendar.getInstance();
        int era = calendar.get(Calendar.ERA);
        int year = calendar.get(Calendar.YEAR);
        int cas = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(era);
        System.out.println(year);
        System.out.println(cas);
        System.out.println(calendar.getTime());

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateformat.format(calendar.getTime()));
    }

    public static void libr_3() throws IOException {
//        File file = new File(directory, "Test.txt");
//        File file = new File("C:\\", "test1.txt");
        File file = new File("test1.txt");
        System.out.println(file.getAbsoluteFile());
//        Узнать доступен ли для чтения
        System.out.println(file.canRead()); // true
        System.out.println(file.exists());
        boolean mkfile = file.createNewFile();
        System.out.println(mkfile);
    }

    public static void libr_4() throws IOException {
        File file = new File("test_skillfactory");
        boolean isexist = file.isDirectory();
        System.out.println(isexist);
        if (!isexist) {
            file.mkdir();
        }
        String[] files = file.list();

        for (String filename : files) {
            System.out.println(filename);
        }
    }

    public static void libr_5() {
        int a = -6, b = -3;
        System.out.println(Mathematics.abs(a));
        System.out.println(Mathematics.max(a, b));
        System.out.println(Mathematics.min(a, b));

    }

    public static void libr_6() {
        byte x = -1;
        int y = -1;
        System.out.println(String.format("%08x and %08x", x, y));
    }

    //    Чтение из файла
    public static void libr_7() throws IOException {
        FileInputStreamEx filesRead = new FileInputStreamEx();
        filesRead.write();
        filesRead.read();
        filesRead.qtyCount();
        filesRead.copyFileUsingStream();
    }

    public static void libr_8() throws IOException {
        FileInputStreamEx filesRead = new FileInputStreamEx();
        filesRead.encoding("test.txt", "Windows-1251", "output.txt", "UTF-8");
        filesRead.getReceipt();

    }

    public static void libr_9() {
        int[] array = {1, 2, -1, 5, 3};
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
        System.out.println(s);
    }

    public static void libr_10() {
        FileInputStreamEx filesRead = new FileInputStreamEx();
        try {
            filesRead.readAllLines();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void libr_11() {

        char[] charArray = new char[5];
        charArray[0] = 'r';
        charArray[1] = 'a';
        charArray[2] = 'w';
        charArray[3] = 'c';
        charArray[4] = 'h';
        Arrays.sort(charArray);
        Arrays.fill(charArray, 'f');
        System.out.println(Arrays.toString(charArray));

        List<Integer> spisok = new ArrayList();
        boolean spCheck = spisok.add(1);
        spisok.add(2);
        System.out.println(spisok);
        System.out.println(spCheck);
        int control = spisok.indexOf(1);
        System.out.println(control);

        Map<Integer, String> map1 = new HashMap();
        map1.put(0, "German");
        map1.put(1, "Ivan");
        System.out.println(map1.containsKey(2));
        System.out.println(map1);
        System.out.println(map1.containsValue("German"));
        System.out.println(map1.keySet());
        System.out.println(map1.values());

        Set<Integer> set1 = new HashSet();
        set1.add(1);
        set1.add(1);
        set1.add(2);
        System.out.println(set1.size());
        System.out.println(set1);

        Queue<Integer> que = new ArrayDeque();
        que.add(1);
        que.add(2);
        System.out.println(que);
    }

    public static void libr_12() {
        Queue queue = new ArrayDeque();
        System.out.println(queue.peek());
//
//        Deque queues = new ArrayDeque();
//        System.out.println(queues.pop());

        Deque queueq = new ArrayDeque();
        System.out.println(queueq.remove());
    }

    public static void libr_13() {
        int numberOfTasks = 5;
        Queue toDoQueue = new ArrayDeque(numberOfTasks);
        Boss boss = new Boss(toDoQueue);
        Worker worker = new Worker(toDoQueue);

        for (int i = 0; i <= numberOfTasks; i++) {
            boss.giveTask("Задание " + i);
        }
        System.out.println("Начальник закончил давать задание");

        for (int i = 0; i <= numberOfTasks; i++) {
            worker.takeTask();
        }

        Deque deque = new ArrayDeque();
        deque.offer(12);
        deque.add(6);
        deque.add(4);

        deque.poll();
        deque.peek();
        System.out.println(deque.element());
    }

    public static void libr_14() {
        Queue<Object> que = new LinkedList();
        que.add(1);
        for (int i = 0; i <= 24; i++) {
            que.add(i);
        }

        que.add(new Date());
        que.add(new Date());
        System.out.println(que);
        Object element = que.poll();
        String str = element.toString(); // безопасное приведение
        System.out.println(str);
    }

    public static void libr_15() {
        Queue<String> queue = new LinkedList();
        queue.add("4");
        queue.add("5");
        System.out.println(queue);

        int cast = Integer.parseInt(queue.poll());
        System.out.println(cast);

    }

    public static void libr_16() {
        Queue<String> keywords = new LinkedList<>();
        keywords.add("Java");
        printList(keywords); // не компилируется
    }

    private static void printList(Queue<?> keywords) {
        for (Object o : keywords) {
            System.out.println(o);
        }
    }

//    public static void collection_lessons() {
//        Collection<? extends String> collection = new LinkedList<>(); // 2
//        collection.add("Hello"); // 3
//        System.out.println(collection.size());
//    }

    public static void processAnyList(List<Integer> list) {
        if (list instanceof LinkedList) {
            LinkedList<Integer> linkedList = (LinkedList<Integer>) list;
            Integer peekedValue = linkedList.peek();
        } else {
            // работаем с методами интерфейса или делаем каст на другую имплементацию
        }
    }

    private static final String TOYOTA = "Toyota";
    private static final String BMW = "Bmw";
    private static final String KIA = "Kia";


    public static void libr_17() {


        Car cars = new Car(TOYOTA, "Camri", false);
        Car cars2 = new Car(KIA, "Rio", false);
        Car cars3 = new Car(BMW, "X5", false);
        Car cars4 = new Car(BMW, "X3", false);
        Car cars5 = new Car(BMW, "X6", false);
        Car cars6 = new Car(TOYOTA, "Raw 4", true);
        Car cars7 = new Car(KIA, "Ceed", false);
        Car cars8 = new Car(TOYOTA, "Yaris", false);
        Car cars9 = new Car(BMW, "320i", false);
        Car cars10 = new Car(TOYOTA, "Corolla", false);

        List<Car> list = new ArrayList();
        list.add(cars);
        list.add(cars2);
        list.add(cars3);
        list.add(cars4);
        list.add(cars5);
        list.add(cars6);
        list.add(cars7);
        list.add(cars8);
        list.add(cars9);
        list.add(cars10);

//        for (Car car : list) {
//
//            if (car.getBrand().equals(KIA)) {
//                list.remove(car);
//            } else if (cars.getBrand().equals(TOYOTA)) {
//                cars.setOnSale(true);
//            }
//        }

        Iterator<Car> iterator = list.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getBrand().equals(KIA)) {
                iterator.remove();
            } else if (car.getBrand().equals(TOYOTA)) {
                car.setOnSale(true);
            }
        }

        for (Car carAll : list) {
            System.out.println(carAll.toString());
        }
    }

    public static void libr_18() {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        System.out.println(list);
    }

    public static void libr_19() {
        Set set = new LinkedHashSet<>();
        Set set2 = new HashSet<>();

        Car cars = new Car(TOYOTA, "Camri", false);
        Car cars2 = new Car(KIA, "Rio", false);
        Car cars3 = new Car(BMW, "X5", false);
        Car cars4 = new Car(BMW, "X3", false);
        Car cars5 = new Car(BMW, "X6", false);
        Car cars6 = new Car(TOYOTA, "Raw 4", true);
        Car cars7 = new Car(KIA, "Ceed", false);
        Car cars8 = new Car(TOYOTA, "Yaris", false);
        Car cars9 = new Car(BMW, "320i", false);
        Car cars10 = new Car(TOYOTA, "Corolla", false);
        Car cars11 = new Car(TOYOTA, "Camri", false);
        Car cars12 = new Car(KIA, "Rio", false);
        Car cars13 = new Car(BMW, "X5", false);
        Car cars14 = new Car(BMW, "X3", false);
        Car cars15 = new Car(BMW, "X6", false);
        Car cars16 = new Car(TOYOTA, "Raw 4", true);
        Car cars17 = new Car(KIA, "Ceed", false);
        Car cars18 = new Car(TOYOTA, "Yaris", false);
        Car cars19 = new Car(BMW, "320i", false);
        Car cars20 = new Car(TOYOTA, "Corolla", false);
        Car cars21 = new Car(KIA, "Rio", false);
        Car cars22 = new Car(BMW, "X5", false);
        Car cars23 = new Car(BMW, "X3", false);
        Car cars24 = new Car(BMW, "X6", false);
        Car cars25 = new Car(TOYOTA, "Raw 4", true);
        Car cars26 = new Car(KIA, "Ceed", false);
        Car cars27 = new Car(TOYOTA, "Yaris", false);
        Car cars28 = new Car(BMW, "320i", false);
        Car cars29 = new Car(TOYOTA, "Corolla", false);
        Car cars30 = new Car(TOYOTA, "Corolla", false);

        List<Car> list = new ArrayList();
        list.add(cars);
        list.add(cars2);
        list.add(cars3);
        list.add(cars4);
        list.add(cars5);
        list.add(cars6);
        list.add(cars7);
        list.add(cars8);
        list.add(cars9);
        list.add(cars10);
        list.add(cars11);
        list.add(cars12);
        list.add(cars13);
        list.add(cars14);
        list.add(cars15);
        list.add(cars16);
        list.add(cars17);
        list.add(cars18);
        list.add(cars19);
        list.add(cars20);
        list.add(cars21);
        list.add(cars22);
        list.add(cars23);
        list.add(cars24);
        list.add(cars25);
        list.add(cars26);
        list.add(cars27);
        list.add(cars28);
        list.add(cars29);
        list.add(cars30);

        Set<Car> carset = new HashSet<>(list);
        for (Car car : carset) {
            System.out.println(car.toString());
        }


    }

    public static void libr_20() {
        Car cars = new Car(TOYOTA, "Camri", false);
        Car cars2 = new Car(KIA, "Rio", false);
        Car cars3 = new Car(BMW, "X5", false);
        Car cars4 = new Car(BMW, "X3", false);
        Car cars5 = new Car(BMW, "X6", false);
        Car cars6 = new Car(TOYOTA, "Raw 4", true);
        Car cars7 = new Car(KIA, "Ceed", false);
        Car cars8 = new Car(TOYOTA, "Yaris", false);
        Car cars9 = new Car(BMW, "320i", false);
        Car cars10 = new Car(TOYOTA, "Corolla", false);
        Car cars11 = new Car(TOYOTA, "Camri", false);
        Car cars12 = new Car(KIA, "Rio", false);
        Car cars13 = new Car(BMW, "X5", false);
        Car cars14 = new Car(BMW, "X3", false);
        Car cars15 = new Car(BMW, "X6", false);
        Car cars16 = new Car(TOYOTA, "Raw 4", true);
        Car cars17 = new Car(KIA, "Ceed", false);
        Car cars18 = new Car(TOYOTA, "Yaris", false);
        Car cars19 = new Car(BMW, "320i", false);
        Car cars20 = new Car(TOYOTA, "Corolla", false);
        Car cars21 = new Car(KIA, "Rio", false);
        Car cars22 = new Car(BMW, "X5", false);
        Car cars23 = new Car(BMW, "X3", false);
        Car cars24 = new Car(BMW, "X6", false);
        Car cars25 = new Car(TOYOTA, "Raw 4", true);
        Car cars26 = new Car(KIA, "Ceed", false);
        Car cars27 = new Car(TOYOTA, "Yaris", false);
        Car cars28 = new Car(BMW, "320i", false);
        Car cars29 = new Car(TOYOTA, "Corolla", false);
        Car cars30 = new Car(TOYOTA, "Corolla", false);

        List<Car> list = new ArrayList();
        list.add(cars);
        list.add(cars2);
        list.add(cars3);
        list.add(cars4);
        list.add(cars5);
        list.add(cars6);
        list.add(cars7);
        list.add(cars8);
        list.add(cars9);
        list.add(cars10);
        list.add(cars11);
        list.add(cars12);
        list.add(cars13);
        list.add(cars14);
        list.add(cars15);
        list.add(cars16);
        list.add(cars17);
        list.add(cars18);
        list.add(cars19);
        list.add(cars20);
        list.add(cars21);
        list.add(cars22);
        list.add(cars23);
        list.add(cars24);
        list.add(cars25);
        list.add(cars26);
        list.add(cars27);
        list.add(cars28);
        list.add(cars29);
        list.add(cars30);

        Map<Car, Integer> carMap = new HashMap<>();
        for (Car car : list) {
            if (carMap.containsKey(car)) {
                int value = carMap.get(car);
                carMap.put(car, ++value);
            } else {
                carMap.put(car, 1);
            }
        }

        for (Map.Entry<Car, Integer> carEntry : carMap.entrySet()) {
            System.out.println(carEntry.getKey() + " " + carEntry.getValue());
        }
    }

    public static void libr_21() {
        Set<Product> set = new TreeSet<>();
        set.add(new Product("SuperBrand", "Kolbasa", 34543234L, LocalDateTime.now()));
        for (Product product : set) {
            System.out.println(product);
        }

    }

    public static void libr_22() {
        Car cars = new Car(TOYOTA, "Camri", false);
        Car cars2 = new Car(KIA, "Rio", false);
        Car cars3 = new Car(BMW, "X5", false);
        Car cars4 = new Car(BMW, "X3", false);
        Car cars5 = new Car(BMW, "X6", false);
        Car cars6 = new Car(TOYOTA, "Raw 4", true);
        Car cars7 = new Car(KIA, "Ceed", false);
        Car cars8 = new Car(TOYOTA, "Yaris", false);
        Car cars9 = new Car(BMW, "320i", false);
        Car cars10 = new Car(TOYOTA, "Corolla", false);
        Car cars11 = new Car(TOYOTA, "Camri", false);
        Car cars12 = new Car(KIA, "Rio", false);
        Car cars13 = new Car(BMW, "X5", false);
        Car cars14 = new Car(BMW, "X3", false);
        Car cars15 = new Car(BMW, "X6", false);
        Car cars16 = new Car(TOYOTA, "Raw 4", true);
        Car cars17 = new Car(KIA, "Ceed", false);
        Car cars18 = new Car(TOYOTA, "Yaris", false);
        Car cars19 = new Car(BMW, "320i", false);
        Car cars20 = new Car(TOYOTA, "Corolla", false);
        Car cars21 = new Car(KIA, "Rio", false);
        Car cars22 = new Car(BMW, "X5", false);
        Car cars23 = new Car(BMW, "X3", false);
        Car cars24 = new Car(BMW, "X6", false);
        Car cars25 = new Car(TOYOTA, "Raw 4", true);
        Car cars26 = new Car(KIA, "Ceed", false);
        Car cars27 = new Car(TOYOTA, "Yaris", false);
        Car cars28 = new Car(BMW, "320i", false);
        Car cars29 = new Car(TOYOTA, "Corolla", false);
        Car cars30 = new Car(TOYOTA, "Corolla", false);

        List<Car> list = new ArrayList();
        list.add(cars);
        list.add(cars2);
        list.add(cars3);
        list.add(cars4);
        list.add(cars5);
        list.add(cars6);
        list.add(cars7);
        list.add(cars8);
        list.add(cars9);
        list.add(cars10);
        list.add(cars11);
        list.add(cars12);
        list.add(cars13);
        list.add(cars14);
        list.add(cars15);
        list.add(cars16);
        list.add(cars17);
        list.add(cars18);
        list.add(cars19);
        list.add(cars20);
        list.add(cars21);
        list.add(cars22);
        list.add(cars23);
        list.add(cars24);
        list.add(cars25);
        list.add(cars26);
        list.add(cars27);
        list.add(cars28);
        list.add(cars29);
        list.add(cars30);

        Map<Car, Integer> carMap = new TreeMap<>();
        for (Car car : list) {
            if (carMap.containsKey(car)) {
                int value = carMap.get(car);
                carMap.put(car, ++value);
            } else {
                carMap.put(car, 1);
            }
        }

        for (Map.Entry<Car, Integer> carEntry : carMap.entrySet()) {
            System.out.println(carEntry.getKey() + " " + carEntry.getValue());
        }
    }

    public static void libr_23() {
        Car cars = new Car(TOYOTA, "Camri", false);
        Car cars2 = new Car(KIA, "Rio", false);
        Car cars3 = new Car(BMW, "X5", false);
        Car cars4 = new Car(BMW, "X3", false);
        Car cars5 = new Car(BMW, "X6", false);
        Car cars6 = new Car(TOYOTA, "Raw 4", true);
        Car cars7 = new Car(KIA, "Ceed", false);
        Car cars8 = new Car(TOYOTA, "Yaris", false);
        Car cars9 = new Car(BMW, "320i", false);
        Car cars10 = new Car(TOYOTA, "Corolla", false);
        Car cars11 = new Car(TOYOTA, "Camri", false);
        Car cars12 = new Car(KIA, "Rio", false);
        Car cars13 = new Car(BMW, "X5", false);
        Car cars14 = new Car(BMW, "X3", false);
        Car cars15 = new Car(BMW, "X6", false);
        Car cars16 = new Car(TOYOTA, "Raw 4", true);
        Car cars17 = new Car(KIA, "Ceed", false);
        Car cars18 = new Car(TOYOTA, "Yaris", false);
        Car cars19 = new Car(BMW, "320i", false);
        Car cars20 = new Car(TOYOTA, "Corolla", false);
        Car cars21 = new Car(KIA, "Rio", false);
        Car cars22 = new Car(BMW, "X5", false);
        Car cars23 = new Car(BMW, "X3", false);
        Car cars24 = new Car(BMW, "X6", false);
        Car cars25 = new Car(TOYOTA, "Raw 4", true);
        Car cars26 = new Car(KIA, "Ceed", false);
        Car cars27 = new Car(TOYOTA, "Yaris", false);
        Car cars28 = new Car(BMW, "320i", false);
        Car cars29 = new Car(TOYOTA, "Corolla", false);
        Car cars30 = new Car(TOYOTA, "Corolla", false);

        List<Car> list = new ArrayList();
        list.add(cars);
        list.add(cars2);
        list.add(cars3);
        list.add(cars4);
        list.add(cars5);
        list.add(cars6);
        list.add(cars7);
        list.add(cars8);
        list.add(cars9);
        list.add(cars10);
        list.add(cars11);
        list.add(cars12);
        list.add(cars13);
        list.add(cars14);
        list.add(cars15);
        list.add(cars16);
        list.add(cars17);
        list.add(cars18);
        list.add(cars19);
        list.add(cars20);
        list.add(cars21);
        list.add(cars22);
        list.add(cars23);
        list.add(cars24);
        list.add(cars25);
        list.add(cars26);
        list.add(cars27);
        list.add(cars28);
        list.add(cars29);
        list.add(cars30);

        Set<Car> carSet = new TreeSet<>(new CarComparator().reversed());
        carSet.addAll(list);
        for (Car car : carSet) {
            System.out.println(car);
        }
    }

    public static void libr_24() {
        StockAccount stockAccount = new StockAccount();
        stockAccount.start();
        long profit = 0;
        Scanner scan = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            command = scan.next();
            switch (command) {
                case "check":
                    System.out.println(stockAccount.money);
                    break;
                case "fix":
                    profit += (long) stockAccount.money - 1000;
                    System.out.println("Profit " + profit);
                    stockAccount.money = 1000;
            }
        }
    }

    public static void libr_25() throws InterruptedException {
        JoinExample.threadTest();
    }

    public static void libr_26() throws InterruptedException {
        InterruptExample.interPotok();
    }

    public static LocalDate of(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public static void libr_27() {
//        String Date = String.valueOf(LocalTime.now());
//        System.out.println(Date);
//        System.out.println(ZoneId.systemDefault());
//
//
//        LocalTime time = LocalTime.of(16, 30); // строка 1
//        time.withHour(14).plusMinutes(15);
//        System.out.println(time);
//
//        LocalDate date = LocalDate.of(2020, 1, 1);
//        Period period = Period.ofYears(4);
//        System.out.println(date.minus(period));
//
//
//        LocalTime time2 = LocalTime.of(12, 30); // строка 1
//        time2.minusHours(4); // строка 2
//        time2 = time2.plusMinutes(30);
//        System.out.println(time2);

        LocalDate date = LocalDate.of(2029, 8, 4);
        Period period = Period.ofDays(3);
        date = date.minus(period); // строка 1
        Duration duration = Duration.ofHours(12);
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(8, 0));
        dateTime.plus(duration); // строка 2
        System.out.println(dateTime);
    }

    public static void libr_28() {
        int value = 70;
//        validate(value, new ValidatorImpl());
        validate(value, (int value1) -> value >= 60);
    }

    public static void validate(int value, Validator validator) {
        boolean isValid = validator.validate(value);
        if (isValid) {
            System.out.println("Great value valid");

        } else {
            System.out.println("Value invalid");
        }
    }

    @FunctionalInterface
    interface Worker1 {
        double doWork(int value, Worker worker);  // метод для работы с лямбдой Worker
    }

    private static void task(int value, Consumer<Integer> param) {
    } // вставьте тип

    public static void libr_29() {
        Lamda getpi = () -> 3.1415;
        task(12, value -> {
        });

        Consumer<List<Integer>> methodRef = Collections::sort; // method reference
        Consumer<List<Integer>> lambda = l -> Collections.sort(l); // lambda-expression

        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith; // method reference
        Predicate<String> lambda2 = s -> s.startsWith(s); // lambda-expression
    }

    public static void libr_30() {
        Optional<Double> opt = Optional.of(22.4);
        System.out.println(opt);

        Optional<Double> avg2 = average(5, 4, 2);
        var avg = average(4, 5, 3);

        System.out.println(avg);
        System.out.println(avg2);

    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }

    public static void libr_31() {
        Stream<String> empty = Stream.empty(); // пустой стрим
        Stream<Integer> singleElement = Stream.of(1); // длина 1
        Stream<Integer> anyElements = Stream.of(1, 2, 3); // длина 3
        Stream<Integer> fromArray = Arrays.stream(new Integer[]{1, 2, 3}); // длина 3

        // Создаем список чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Применяем Stream для фильтрации четных чисел и вычисления их суммы
        int sumOfEvenNumbers = numbers.stream()  // Преобразуем список в Stream
                .filter(n -> n % 2 == 0)  // Фильтруем только четные числа
                .mapToInt(Integer::intValue)  // Преобразуем Integer в int
                .sum();  // Суммируем

        System.out.println("Сумма четных чисел: " + sumOfEvenNumbers);

        Stream<Integer> infinite = Stream.iterate(2, x -> x * 2);
        System.out.println(infinite.anyMatch(test -> test / 8 == 0));


        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")) // оставляем лишь элементы начинающиеся с m
                .forEach(System.out::println); // monkey

        Stream<String> stream = Stream.of("duck", "duck", "duck", "goose");
        stream.distinct() // оставляем уникальные элементы
                .forEach(System.out::println); // duckgoose

        Stream<Integer> str = Stream.iterate(1, n -> n + 1);
        str.skip(5) // пропускаем первые 5 элементов
                .limit(2) // ограничиваем данные 2 элементами
                .forEach(System.out::println); // 67

    }

    public static void libr_32() {
        Stream<Integer> stream = Stream.iterate(1, integer -> integer + 1);
        boolean match = stream
                .map(String::valueOf)
                .distinct()
                .limit(5)
                .noneMatch(str -> str.length() != 1);
        System.out.println(match);

        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name : list) {
            if (name.length() == 4) {
                filtered.add(name);
            }
        }

        Collections.sort(filtered);
        Iterator<String> iter = filtered.iterator();

        if (iter.hasNext()) {
            System.out.println(iter.next());
        }
        if (iter.hasNext()) {
            System.out.println(iter.next());
        }

        List<String> listsorted = new ArrayList<>();
        List<String> list2 = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        list2.stream()
                .filter(n -> n.length() == 4)
                .sorted()
                .distinct()
                .limit(2)
                .forEach(listsorted::add);
        System.out.println(listsorted);
    }

    public static void libr_33() {


        Path path = Paths.get("C:\\test.txt");
        System.out.println("The path name is: " + path); // The path name is: land/hippo/harry.happy

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("Element " + i + " is : " + path.getName(i));
        }

        System.out.println("Filename is " + path.getFileName());

        try {
            boolean fileExist = Files.exists(Paths.get("C:\\test.txt"));
            System.out.println(fileExist);
        } catch (Exception e) {
            System.out.println("File not found " + e.getMessage());
        }
// Чтение и запись
        Path path2 = Paths.get("C:\\test.txt");
        try (BufferedReader reader = Files.newBufferedReader(path2, StandardCharsets.US_ASCII)) { // Выбираем кодировку файла
            // читаем со стрима
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            // Handle file I/O exception
        }

        Path path3 = Paths.get("C:\\test.txt");
        List<String> data = new ArrayList<>();
        try (BufferedWriter writer = Files.newBufferedWriter(path3, Charset.defaultCharset())) {
            writer.write("Hello World");
        } catch (IOException e) {
            // Handle file I/O exception
        }

        Path path4 = Paths.get("C:\\test.txt");
        try {
            List<String> lines = Files.readAllLines(path4); // сохраняем строки из файла в лист
            for (String line : lines) {
                System.out.println(line); // выводим содержимое на консоль
            }
        } catch (IOException exception) {
            // Handle file I/O exception
        }
    }

    public static void libr_34() {
        User usr = new User("German", "Baklagin", "+79004551650", "cszc6791", Userho.User);
//        usr.toJson(usr);
//        usr.toString();
        UserHouse usrHouse = new UserHouse();
        usrHouse.House("cszc6791");
    }

        /*
        Finish module 1

        Start Database module
    */

    public static void libr_35() {
        List<String> lst = new ArrayList<>();

        JsonArray res = DatabasePostgresql.query("SELECT * FROM hosts");
//        int sum = countIpAddresses(res);
//        System.out.println(sum);
        if (res != null) {
            for (JsonElement element : res) {
                JsonObject jsonObject = element.getAsJsonObject(); // Преобразуем в JsonObject
                if (jsonObject.has("ipadress")) { // Проверяем, существует ли ключ "ipadress"
                    String ipAddress = jsonObject.get("ipadress").getAsString();  // Получаем значение по ключу "ipadress"
                    lst.add(ipAddress);

                    System.out.println("IP Address: " + ipAddress); // Выводим IP адрес
                } else {
                    System.out.println("IP address not found for this entry.");
                }
            }
        }
//        Два метода
//        1 метод
        Set<String> uniqIP = new HashSet<>(lst);
//        2 метод
        long uniqCount = lst.stream()
                .distinct()
                .sorted()
                .count();
        System.out.println(uniqCount);
        System.out.println(uniqIP.size());
        System.out.println(lst);
        passToDatabases();
    }

    public static int countIpAddresses(JsonArray quaryRes) {
        int count = 0;
        if (quaryRes != null) {
            for (JsonElement element : quaryRes) {
                JsonObject jsonObject = element.getAsJsonObject();
                if (jsonObject.has("ipadress")) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void passToDatabases() {
        User usr = new User("German", "Baklagin", "+79004551650", "cszc6791", Userho.Admin);

//        DatabasePostgresql.insertUserToDatabase(usr.name, usr.surname, usr.password, usr.phoneNumber);
    }

    private static Dao boxdao;

    public static void libr_37() {
        boxdao = new BoxDao();
        boxdao.save(boxdao);
    }


    /*
     *
     * Работа с Базой данных jdbc Postgresql
     *
     * */


    private static final String URL = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";
    private static Connection connection;

    public static void DatabasePostgresqlConnection() throws SQLException {
        List<String> list = new ArrayList<>();
//        connection = DriverManager.getConnection(URL);
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            System.out.println("Соедение с БД успешно");
            System.out.println("Соедение успешно закрыто");
            String query = "SELECT * from userdb";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(resultSet.getString("username"));
//                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("username");
                System.out.println("ID: " + ", Name: " + name);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();

        }

        Set<String> set = new HashSet<>(list);
        System.out.println(set);

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i));
        }
        System.out.println(map);
        System.out.println(map.size());
    }

    public static void DatabasePostgresqlConnection_2() throws SQLException {
        List<String> list = new ArrayList<>();
//        connection = DriverManager.getConnection(URL);
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            System.out.println("Соедение с БД успешно");
            System.out.println("Соедение успешно закрыто");
            String query = "SELECT * from userdb where username=?";
            // Подготавливаем запрос с параметром
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "German");  // Устанавливаем значение параметра (например, 'German')
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("username");  // Допустим, в таблице есть поле "name"
                list.add(data);  // Добавляем значение в список
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();

        }
        System.out.println(list);
    }

    public static void libr_39() throws IOException, SQLException {
        SimpleHttpServer.server();
    }

    public static int fact(int n) {
        int res;
        if (n == 1) return 1;
        res = fact(n - 1) * n;
        return res;
    }

    public static void vaTest(int... v) {
        System.out.println(v.length);
        for (int x : v)
            System.out.println(x);
        System.out.println();
    }

    public static void appleEnum() {
        Apple ap;
        Apple[] allApples = Apple.values();
        for (Apple apple : allApples) {
            System.out.println(apple);
        }
        try {
            System.out.println(Apple.valueOf("RedDel"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void jsonArr() {
        JsonArray arr = new JsonArray();

        String name = "German";
        String name2 = "Baklagin";

        JsonObject obj = new JsonObject();
        obj.addProperty("username", "German");
        obj.addProperty("username", "German");
        arr.add(obj);

        JsonObject obj2 = new JsonObject();
        obj2.addProperty("username", "Baklagin");
        arr.add(obj2);

        Gson gson = new Gson();
        String jsonResp = gson.toJson(arr);
        System.out.println(jsonResp);

    }

    public static void jsonArr2() {
        JsonArray arr = new JsonArray();
        JsonArray usernames = new JsonArray();

        usernames.add("German");
        usernames.add("Baklagin");

        JsonObject obj = new JsonObject();
        obj.add("username", usernames);
        arr.add(obj);

        Gson gson = new Gson();
        String jsonResp = gson.toJson(arr);
        System.out.println(jsonResp);
    }

    public static void jsonArr3() {
        JsonObject obj = new JsonObject();

        JsonArray questions = new JsonArray();
        questions.add("Я сейчас на конференции");
        questions.add("Я сейчас на конференции");

        obj.add("question", questions);

        Gson gson = new Gson();
        String json = gson.toJson(obj);

        System.out.println(json);

    }

    public static void streamFunc() {
        // Вызов метода st() из класса StreamAPI
        StreamAPI.st();

        // Можно добавить задержку, чтобы увидеть асинхронную обработку
        try {
            Thread.sleep(6000);  // Ждём немного, чтобы асинхронные задачи успели выполниться
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершение работы программы.");

    }

    public static void selfedu_7() {
        double pi, r, a;
        r = 10.8;
        pi = Math.PI;
        a = pi * r * r;
        System.out.println(a);

    }

    public static void books_1() {
        double num = 5;
        int num2 = (int) num;
        double a = 3.0, b = 4.0;
        double c = Math.sqrt(a * a + b * b);
        System.out.println(c);
        System.out.println(num2);
    }

    public static void books_2() {
        int[] months_days = new int[]{1, 2, 3, 4, 5};
        for (int val : months_days) {
            System.out.println(val);
        }
        int[][] twoD = new int[4][5];

        B subOb = new B(1, 2);
        subOb.show();

        Rectangle r = new Rectangle(9, 5);

        System.out.println("S = " + r.getArea());
    }

    public static void books_3() {
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток");
        t.setName("My thread");
        System.out.println("После изменения" + t);
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void books_4() {
        MyThread mythread = new MyThread();
        mythread.t.start();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void books_5() {
        MyThread2 mythread2 = new MyThread2();
        mythread2.start();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток");
                Thread.sleep(1000);
            }
            System.out.println("Главный поток");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void books_6() {
        Thread th = new Thread(() -> {
//            Код потока
            System.out.println("Выполнятся логика исполь лямбда выражения");
        });

        th.start();
    }

    public static void books_7() {
        ExecutorService ex = Executors.newFixedThreadPool(5);
//newFixedThreadPool
        ex.submit(() -> {
//            код потока
            System.out.println("Выполнятся поток");
        });
        ex.shutdown();
    }

    public static void books_8() {
        Apple ap;
        ap = Apple.RedDel;
        System.out.println(ap);

        Apple[] allapple = Apple.values();
        for (Apple apple : allapple) {
            System.out.println(apple);
        }
        ap = Apple.valueOf("RedDel");
        System.out.println(ap);


    }

    public static void books_9() {
        Apple ap, ap2, ap3;
        for (Apple a : Apple.values()) {
            System.out.println(a);
        }

        ap = Apple.RedDel;
        ap2 = Apple.GoldenDelm;
        ap3 = Apple.RedDel;

        if (ap.compareTo(ap2) < 0)
            System.out.println(ap + "находиться перед " + ap2);
    }

    public static void books_10() {
        Integer iob = Integer.valueOf(100);
        int i = iob.intValue();
        System.out.println(i + " " + iob);
    }

    public static void books_11() throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("Vvodite simvoly dly vschoda q");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }

    public static void books_12() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String str;
        System.out.println("Вводите строки текста");
        System.out.println("Для завершения введеите stop");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));

    }

    public static void books_13(String[] args) {
        int i;
        FileInputStream fin;
        if (args.length != 1) {
            System.out.println(" use show file name file");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось открыть файл");
            return;
        }
        try {
            do {
                i = fin.read();
                if (i != 1)
                    System.out.println((char) i);
            } while (i != -1);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла");
            }
        }
    }

    public static void books_14() throws Exception {
        Gen<Integer> iob = new Gen<Integer>(88);
        iob.showType();
        int v = iob.getOb();
        System.out.println(v);

        Gen<String> iobstr = new Gen<String>("Heloo");
        iobstr.showType();
        String ve = iobstr.getOb();
        System.out.println(ve);

        ApacheCamel.apachecamel_message();
    }

    public static void books_15() {
        MyNumber myNum;
        myNum = () -> 123.45;
        System.out.println(myNum.getValue());
        NumericTest numTest = n -> (n % 2) == 0;
        if (numTest.test(10)) {
            System.out.println("10 Четное число");
        }
        NumericTest negativeSravneni = (n) -> n >= 0;
        if (negativeSravneni.test(1)) {
            System.out.println("Число 1 является неотрицательным");
        }

        NumerickTest2 isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2)) {
            System.out.println("Является множетелем");
        }

        NumerickFunc factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }

            return result;
        };
        System.out.println("Факториал 3 равен: " + factorial.func(3));
    }

    public static void books_16() {
        int eventCode = 6010;

        int priorityLevel = switch (eventCode) {
            case 1000, 115:
                yield 1;
            case 2000, 6010:
                yield 2;
            default:
                yield 0;
        };

        System.out.println(priorityLevel);

        int priorityLevel2 = switch (eventCode) {
            case 1000, 115 -> 1;
            case 2000, 6010 -> 2;
            default -> 0;
        };
        System.out.println(priorityLevel2);

        boolean stopNow;
        int priorityLevel3 = switch (eventCode) {
            case 1000, 1110 -> {
                stopNow = false;
                System.out.println("Тревога");
                yield 1;
            }
            case 6010, 10001 -> {
                stopNow = true;
                System.out.println("Опасность");
                yield 2;
            }
            default -> {
                stopNow = false;
                yield 0;
            }
        };


    }

    public static void books_17() {
        char[] chars = {'a', 'b', 'c'};
        String s = new String(chars);
        System.out.println(s.length());
        System.out.println(s);
        String s2 = "abc";
        char ch;
        ch = "abc".charAt(1);
        System.out.println(ch);
    }

    public static void books_18() {
        Double d1 = Double.valueOf(3.14159);
        Double d2 = Double.valueOf("3.14159E-5");
        System.out.println(d1 + " " + d2);
        Runtime r = Runtime.getRuntime();
        Process p = null;

        try {
            p = r.exec("Notepad");
            p.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void books_19() {
        try {
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "testfile");
            proc.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void books_20() {
        long start, end;
        System.out.println("Хронометраж цикла for от 0 до 100 000 000");
        start = System.currentTimeMillis();
        for (long i = 0; i < 100_000_000L; i++) {

        }
        end = System.currentTimeMillis();
        System.out.println("Затраченное время: " + (end - start) + "mc");
    }

    public static void books_21() {
        byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74};
        byte[] b = {77, 77, 77, 77, 77, 77, 77, 77, 77, 77};
        System.out.println("a= " + new String(a));
        System.out.println("b= " + new String(b));
        System.arraycopy(a, 0, b, 0, a.length);
        System.out.println("a= " + new String(a));
        System.out.println("b= " + new String(b));

    }

    public static void books_22() {
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("C");
        a1.add("A");
        a1.add("E");
        a1.add("B");
        a1.add("D");
        System.out.println("Size: " + a1.size());

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(1);
        a2.add(2);
        a2.add(3);
        a2.add(4);

        Integer[] ia = new Integer[a2.size()];
        ia = a2.toArray(ia);
        int sum = 0;
        for (int i : ia) {
            sum += i;
        }
        System.out.println(sum);


        LinkedList<String> ll = new LinkedList<String>();
        ll.add("C");
        ll.add("A");
        ll.add("E");
        ll.add("B");
        ll.add("D");
        ll.addLast("R");
        ll.addFirst("G");
        System.out.println(ll);
        System.out.println(Collections.max(ll));
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("C");
        arr.add("A");
        arr.add("E");
        arr.add("B");
        System.out.println("Исходное состояние arr " + arr);
        ListIterator<String> litr = arr.listIterator();

        while (litr.hasNext()) {
            String element = litr.next();
            System.out.print(element + " ");
        }

        ListIterator<String> litr2 = arr.listIterator();
        while (litr2.hasNext()) {
            String element = litr2.next();
            litr2.set(element + "+");
        }
        System.out.println("Модифицированное состояние " + arr);

        while (litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element + " ");
        }

        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        System.out.println("Содержимое arr2");

        for (int v : arr2) {
            System.out.print(v + " ");
        }

        System.out.println();

        int summ = 0;
        for (int v : arr2) {
            summ += v;
        }
        System.out.println("Summ " + summ);
    }

    public static void books_23() {
        ArrayList<Double> arr = new ArrayList<Double>();
        arr.add(1.0);
        arr.add(2.0);
        arr.add(3.0);
        arr.add(4.0);
        arr.add(5.0);
        System.out.println("Содержимое arr");
        Spliterator<Double> splitr = arr.spliterator();
        while (splitr.tryAdvance((n) -> System.out.println(n))) ;

        splitr = arr.spliterator();

    }

    public static void books_24() {

        HashMap<String, Double> hm = new HashMap<String, Double>();
        hm.put("John Doe", 3434.34);
        hm.put("Tom Smith", 123.22);
        hm.put("Jane Beaker", 1378.00);
        hm.put("Tod Hall", 99.22);

        Set<Map.Entry<String, Double>> set = hm.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        double balance = hm.get("John Doe");
        hm.put("John Doe", balance + 1000);

        System.out.println("Новый баланс клиента John Doe: " + hm.get("John Doe"));
    }

    public static void books_25() {
        TreeMap<String, Double> tm = new TreeMap<String, Double>();
        tm.put("John Doe", 3434.34);
        tm.put("Tom Smith", 123.22);
        tm.put("Jane Beaker", 1378.00);
        tm.put("Tod Hall", 99.22);

        Set<Map.Entry<String, Double>> set = tm.entrySet();
        for (Map.Entry<String, Double> me : set) {
            System.out.println(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();

        double balance = tm.get("John Doe");
        tm.put("John Doe", balance + 1000);
        System.out.println("Новый баланс клиента John Doe: " + tm.get("John Doe"));
    }

    // Сортировка в обратном порядке с использованием компатора
    public static void books_26() {
        TreeSet<String> ts = new TreeSet<String>(new MyComparator());
        ts.add("C");
        ts.add("A");
        ts.add("E");
        ts.add("B");
        ts.add("D");
        for (String element : ts) {
            System.out.print(element + " ");
        }
        System.out.println();

    }

    public static void books_27() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);
        Comparator<Integer> r = Collections.reverseOrder();
        Collections.sort(ll, r);
        System.out.println("Список отсортирован в обратном порядке: ");
        for (int i : ll) {
            System.out.println(i + " ");
        }
        System.out.println();
        Collections.shuffle(ll);
        System.out.print("Список перетасован: ");
        for (int i : ll) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Collections.max(ll));
        System.out.println(Collections.min(ll));
    }

    public static void books_28() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = -3 * i;
        }
        System.out.println("Исходное содержимое: ");
        for (int i: array){
            System.out.print(i + " ");
        }
        Arrays.sort(array);
        System.out.println();
        for (int i: array){
            System.out.print(i + " ");
        }
        Arrays.fill(array, 2,6,-1);
        System.out.println("Содержимое после fill: ");
        for (int i: array){
            System.out.print(i + " ");
        }
        Arrays.sort(array);
        System.out.println();
        for (int i: array){
            System.out.print(i + " ");
        }
        System.out.println();
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);

    }

    public static void display(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void books_29() {
        Vector<Integer> vector = new Vector<>(3,2);
        System.out.println("Емкость до: " + vector.capacity());
        System.out.println("Размер до: " + vector.size());

        vector.addElement(1);
        vector.addElement(2);
        vector.addElement(3);
        vector.addElement(4);

        System.out.println();
        System.out.println("Емкость после: " + vector.capacity());
        System.out.println("Размер после: " + vector.size());


    }

    public static void books_30() {
        Observable<String> stream = Observable.just("one", "two", "three");
        stream
//                .map(String::toUpperCase)
//                .filter(s -> s.length() > 2)
                .subscribe(System.out::println);

    }

    public static void books_31() {
        Observable<Long> timer = Observable.interval(0, 1, TimeUnit.SECONDS);

        timer
                .map(tick -> readTemperature())              // каждый тик — новая температура
                .filter(temp -> temp > 25)                   // фильтруем "горячие" значения
                .subscribe(
                        temp -> System.out.println("🔥 Высокая температура: " + temp + "°C"),
                        Throwable::printStackTrace
                );

        // Чтобы не завершался main-поток (Rx работает асинхронно)
        try {
            Thread.sleep(20000); // 20 секунд работы
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Эмуляция "чтения" с датчика
    public static double readTemperature() {
        double value = 20 + Math.random() * 10; // от 20 до 30
        System.out.println("📡 Считано: " + value + "°C");
        return value;
    }

    /**
     * Работы стрим потоков данных реактивность
     */

    public static void books_32() {
        EventBus.messagesString.filter(msg -> msg.contains("temp")).subscribe(msg -> {
            System.out.println(msg);
        });
        EventBus.messagesString.onNext("Hello temp");


        EventBus.messagesNumber.subscribe(msg -> {
            System.out.println(msg);
        });
        EventBus.messagesNumber.onNext(55);
    }
}

