package org.example;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void libr_11(){

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


    public static void libr_17(){


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
            }else if (car.getBrand().equals(TOYOTA)) {
                car.setOnSale(true);
            }
        }

        for(Car carAll: list){
            System.out.println(carAll.toString());
        }
    }

    public static void libr_18(){
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                list.add(i);
            }
        }
        System.out.println(list);
    }

    public static void libr_19(){
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
        for(Car car: carset){
            System.out.println(car.toString());
        }


    }

    public static void libr_20(){
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
        for (Car car: list){
            if(carMap.containsKey(car)){
                int value = carMap.get(car);
                carMap.put(car,++value);
            }else{
                carMap.put(car,1);
            }
        }

        for (Map.Entry<Car,Integer> carEntry : carMap.entrySet()){
            System.out.println(carEntry.getKey() + " " + carEntry.getValue());
        }
    }

    public static void libr_21() {
        Set<Product> set = new TreeSet<>();
        set.add(new Product("SuperBrand", "Kolbasa", 34543234L, LocalDateTime.now()));
        for (Product product: set){
            System.out.println(product);
        }

    }

    public static void libr_22(){
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
        for (Car car: list){
            if(carMap.containsKey(car)){
                int value = carMap.get(car);
                carMap.put(car,++value);
            }else{
                carMap.put(car,1);
            }
        }

        for (Map.Entry<Car,Integer> carEntry : carMap.entrySet()){
            System.out.println(carEntry.getKey() + " " + carEntry.getValue());
        }
    }

    public static void libr_23(){
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
        for(Car car : carSet){
            System.out.println(car);
        }
    }

    public static void libr_24(){
        StockAccount stockAccount = new StockAccount();
        stockAccount.start();
        long profit = 0;
        Scanner scan = new Scanner(System.in);
        String command =  "";
        while(!command.equals("exit")){
            command = scan.next();
            switch(command){
                case "check":
                    System.out.println(stockAccount.money);
                    break;
                case "fix":
                    profit += (long)stockAccount.money - 1000;
                    System.out.println("Profit " + profit);
                    stockAccount.money = 1000;
            }
        }
    }


}
