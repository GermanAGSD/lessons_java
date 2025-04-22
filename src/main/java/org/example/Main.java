package org.example;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.lessons_books.*;
import static org.example.lessons_skillfactory_1.*;

/*
*  Общедоступный класс название Main
* Типы данных
*/
public class Main {
//    Определение класса - метод main
    public static void main(String[] args) {

        String name = "German"; // Строковыее значения
        byte peremennay_1 = 127; // : -128
        short peremennay_2 = 32767; // : -32768
        int peremennay_3 = 2147483647; // 2147483648
        long peremennay_4 = 922337; // 9233720368547775807
        float peremennay_5 = 0.01f;
        double peremennay_6 = 0.02;
        char peremennay_7 = 'c'; // char символы b и числа 0 до 65535
        boolean peremennay_8 = true;
        final double PI = 3.14159; // Константная перменная

//        System.out.println("Hello world!");
//        System.out.println(peremennay_6);
//        // Создаем ObjectMapper — основной класс для работы с JSON
//
////        Операция присваивание
//        short a = 6;
//        a = 7;
//        int b = 1;
//        b = b + 1;
//        a = (short) b; // приведение типов
//        b = a;
//
//        float var_f = 8.7f;
//        int var_i;
//        var_i = (int) var_f; // приведение типов
//        System.out.println(var_i); // 8
//        String str = "5";
//        int parse = Integer.parseInt(str);
//        System.out.println(parse);
//        main2();
//        main3();
//        main4();
//        main5();
//        main6();
//        main7();
//        main8();
//        main9();
//        main10();
//        main11();
//        main12();
//        main13();
//        main14();
//        main15();
//        main16();
//        main17();
//        main18();
//        main19();
//        main20();
//        main21();
//        objectProgramming.test();
//        skillFactroy();
//        Stack();
//        book_1();
//        book_2();
//        book_5();
//        book_7();
//        module_3();
//        module_3_1();
//        module_3_2();
//        module_3_3();
//        module_4_17();
//        module_4_11();
//        name();
//        sort();
//        sortlength();
        jframeTest();








    }

//    public static void quaery() {
//
//
//        Connection connection = DatabasePostgresql.connectToDatabase();
//
//        // Выполнение SQL-запроса
//        if (connection != null) {
//            String query = "SELECT * FROM hosts";
////            DatabasePostgresql.executeQueryJson(connection, query);
//            JSONArray result = DatabasePostgresql.executeQueryJson(connection, query);
//            System.out.println(result.toString(1));
//            // Закрытие соединения
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
//            }
//        }
//    }

    public static void updateData(Integer data){
        int sum = (int)data;
        System.out.println("Данные отправлены на сервер: " + data);

    }
/*
*    Консольный ввод вывод данных
      System.out.print() - без перехода на новую строку
      System.out.println("Yes"); - с переходом на новую строку
      System.out.printf()  - форматированный вывод данных
* */
    public static void main2(){
        short x = 5;
        double y = 4.5;
        float z = 1.2f;
        System.out.println(x);
        System.out.println("x: " + x);
        System.out.println("Yes");

        System.out.printf("x: %d, y: %f: z: %.2f\n",x,y,z);
// Ввод данных

        Scanner inputValue = new Scanner(System.in);
        System.out.print("Input num");
        byte num = inputValue.nextByte(); // объект сканнер позволяет вводить с клавиуатуры

        System.out.print(num);
        System.out.print("Input name");
        String name = inputValue.nextLine();

        System.out.print("Input age");
        int age = inputValue.nextInt();
        System.out.print("Name: " + name + ", Age: " + age);

        inputValue.close();


        Point pt = new Point();
        Point pt2 = new Point(1,2);
//        pt.x = 5;
//        pt.y = 4;
        System.out.println("X=: " + pt.x +" " +"y=:" + pt.y + " Color: " + pt.color);
        System.out.println("X=: " + pt2.x +" " +"y=:" + pt2.y);

        SetAndGet r1 = new SetAndGet(0,0,10,20);
        SetAndGet r2 = new SetAndGet(40,20,100,200);

        r1.setLeftTop(2,3);
        int s1 = r1.square();
        int s2 = r2.square();

        System.out.println(s1);
        System.out.println(s2);

        PublicPrivate pr1 = new PublicPrivate();
        PublicPrivate publicPrivate = new PublicPrivate(1,2,3,4);



        StaticFinal st1 = new StaticFinal();
        StaticFinal st2 = new StaticFinal();
        System.out.println(StaticFinal.getCnt());
        ClassVlozeny cl1 = new ClassVlozeny("Жучка");
        cl1.run();
        ClassVlozeny cl2 = new ClassVlozeny("Жучка 2");
        cl2.run();
        System.out.println(ClassVlozeny.Stat.counter);

        Line l1 = new Line();
        l1.width = 1;
        l1.x1 = 5;
        l1.id = 1;
        l1.Show_id();
        l1.draw();

        ToyotaCorolla car_1 = new ToyotaCorolla();
        ToyotaCamry car_2 = new ToyotaCamry();
        car_1.go();
        car_1.stop();
        car_1.draw();

        car_2.go();
        car_2.stop();
        car_2.draw();

        final int N = 4;

        AbstractClass cars[] = new AbstractClass[N];
        cars[0] = new ToyotaCorolla();
        cars[1] = new ToyotaCamry();
        cars[2] = new ToyotaCorolla();
        cars[3] = new ToyotaCamry();

        for (int i = 0; i < N; i++) {
            cars[i].go();
            cars[i].stop();
            cars[i].draw();

        }

        GeomFigure geomfigure = new GeomFigure();
        double result = geomfigure.getSquare(10,10);
        geomfigure.draw(10);
        System.out.println(result);
        GeomFigure2 geomfigure2 = new GeomFigure2();
        geomfigure2.getSquare(10,10);
        geomfigure2.draw(2);
        Line2 line2 = new Line2();
        line2.SetCoords(10,10,5,5);
        line2.draw(1);
        Geometrical.showInterval();

        String phone = "+79210111954";
        System.out.println(phone.length());
        User user = new User("german", "backlagin", "+79004551650", "cszc6791");
        user.showUser();


    }
/*
*   Арифметические операции
* */
    public static  void main3(){

        int a = 5, b = 7;
        int c = a + b;
        short d = (short)(c + 5 + a + 7);

        float x = 5.6f, y = 7.6f;
        int z = (int)(3*a);

        double e = (double) a / b;

        int sot = 10 % 3;

        short var  = 5;

        var++;
        System.out.println("var++: " + var);
        var--;

        System.out.println("var--: " + var);
        System.out.println("a % b: " + sot);
        System.out.println("a / b: " + e);
        System.out.println(z);
        System.out.println(d);
        System.out.println(c);
    }
/*
* Условные операторы if switch
* */
    public static void main4(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        if( num < 0){
            num = num * -1;

        }else if(num == 0){
            System.out.print("Null: \n"+ num);
        }else {
            System.out.print("Num > 0: \n" + num);
        }



        short item = -1;
        System.out.print("1 - Площадь треугольника. 2 - Площадь прямоугольника\n");
        item = in.nextShort();
        double h, a, S = 0;
        if(item == 1){
            System.out.print("Введите высоту h и основание треугольника\n");
            h = in.nextDouble();
            a = in.nextDouble();
            S = 0.5*h*a;
        } else if (item == 2) {
            System.out.print("Введите стороны прямоугольника\n");
            h = in.nextDouble();
            a = in.nextDouble();
            S = h * a;
        }
        System.out.println("Площадь равна: \n" + S);
        in.close();
    }
// Проверка входит ли число в диапазон [a:b] -2 : 5
    public static void main5(){
        double a;
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();

        if(a <= 5 && a >= -2){
            System.out.print("Входит в диапазон -2:5 \n" + a);
        }else{
            System.out.print("Не входит в диапазон: \n" + a);
        }

        in.close();
        boolean check = true;
        if(check){
            System.out.print("Check True\n");
        } else if (!check) {
            System.out.print("Check false\n");
        }

    }

    public static void main6(){
        short item;
        System.out.print("0 - выход из программы, 1 - выбрать площадь треугольника");
        Scanner in = new Scanner(System.in);
        item = in.nextShort();

        switch (item){
            case 1:
                System.out.println("Выбрана площадь треугольника");
                break;
            case 0:
                System.out.println("Выход из программы");
                break;
            default: System.out.println("Ни выбран ни один пункт");

        }
        in.close();
    }
/*
* Операторы циклов while for do while
* */
    public  static  void main7(){

        // Example 1
        double S = 0;
        int n = 1;

        while (n < 1000){
            S += 1.0 / n;
            n++;
        }
        System.out.println(S);

        // Example 2
        double P = 0;
        int x = 1;
        Scanner in = new Scanner(System.in);
        while (P < 100 && x != 0){
            System.out.print("Введите число");
            x = in.nextInt();
            P += n;
        }
        System.out.println(P);
        in.close();

        // Example 3
        int Z = 0;
        int i = 1;
        while((Z += ++i) < 50);
        System.out.println(Z);
    }
//    For
    public static void main8() {

        double S = 0;
        for (int n = 1; n < 1000; ++n) {
            S += 1.0 / n;

        }
        System.out.println(S);


//    f(x) = kx +b, x = 0;0.1;0.2...
        double f, k, b;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите k & b: ");
        k = in.nextDouble();
        b = in.nextDouble();

        for (double x = 0; x <= 1; x+=0.1) {
            f = k * x + b;
            System.out.print(f+" ");
        }

        in.close();
    }

    public static void main9(){
        final int sectret_code = 13;
        int code_ent;
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Введите секретный код: ");
            code_ent = in.nextInt();
        } while (code_ent != sectret_code);

        System.out.println("Вы ввели верный код");
        in.close();
    }
//    s = всех N - 1 при i = 0 и всех M - 1 при i = 0 * i * j
    public static void main10(){
        int N = 7, M = 7, S = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                S += i * j;
            }
        }
        System.out.println(S);
    }
/*
* Массивы
* */
    public static void main11(){
        // y = kx + b, x = 0,1,2,3 .. 99
        float k = 0.5f, b = 2.0f;
        float y[] = new float[100];

        for (int x = 0; x < 100; x++) {
            y[x] = k * x + b;
        }

        for (int x = 0; x < 100; x++) {
            System.out.println(y[x] + " ");
        }

    }

    public static void main12(){
        int powers[] = new int[]{1,2,3,4,6};
        for (int x = 0; x < powers.length; x++) {
            System.out.println(powers[powers.length -1]);
        }
    }
    // int ar2D[][] = new int[3][4];
    // 2D - massive // Массив 10 * 10 1 со сдвигом вправо
    public static void main13(){
        final int N = 10;
        int E[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j){
                    E[i][j] = 1;
                }else{
                    E[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(E[i][j]);
            }
            System.out.print("\n");
        }
    }
//  Зубчатый массив
    public static void main14(){
        short z[][] = new short[5][];
        z[0] = new short[3];
        z[1] = new short[4];
        z[2] = new short[2];
        z[3] = new short[3];
        z[4] = new short[1];

        short cnt = 1;
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length; j++) {
                z[i][j] = cnt;
                cnt++;
            }
        }

        for (int i = 0; i < z.length; i++) {
            for (short val : z[i]) {
                System.out.print(val + "");
            }
            System.out.print("\n");
        }
    }
// Удаление зачение из массива
    public static void main15(){
        final int N = 9;
        short a[] = new short[N];
        for (int i = 0; i < N; i++) {
            a[i] = (short)(i+1);
        }
        for (int i = 5; i < N -1; i++) {
            a[i] = a[i + 1];
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
//    Вставка значения массива по определенному индексу
    public static void main16(){
        short a[] = new short[] {1,2,3,5,6,7,8,9,9};
        for (int i = 8; i > 3; i--) {
            a[i] = a[i-1];
        }


        if(a[3] != 4){
            a[3] = 4;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

//  Сортировка элеентов массива всплывающего пузырка 3 5 1 6 2 4
//  Просматриваем все элементы находим самое маленоькое меняем местами
    public static void main17(){
        byte a[] = new byte[] {3,5,1,6,2,4};
        for (int i = 0; i < a.length - 1; i++) {
            byte min = a[i];
            int pos = i;

            for (int j = i + 1; j < a.length; j++)
                if(min > a[j]){
                    pos = j;
                    min = a[j];
                }

            byte t = a[i];
            a[i] = a[pos];
            a[pos] = t;
        }
        for(short val : a) System.out.print(val + "");
    }

//    Строки Java
    /*
    * length
    * toCharArray
    * isEmpty
    * concat
    * valueof
    * join
    * compare
    * ........................................
    * */
    public static String string01ToUp(String str){
        if(str == null && str.isEmpty()){
            return str;
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    public static void main18(){
        String str1 = "german";
        String str2 = new String(); // пустая строка
        String str3 = new String(new char[] {'h', 'e', 'l', 'l', 'o'}); // массив символов
        String str4 = new String(new char[] {'w', 'e', 'l', 'c', 'o', 'm', 'e'}, 3,4); // массив символов со срезом от до
        String str5 = "Are Welcome";
        if(str2.isEmpty()) System.out.println("String Empty: str2");
        str1 = string01ToUp(str1);
        System.out.println("String 1 value to UpperCase: " + str1);

        if(str1.contains("J")) System.out.println("Java contains: J");
        char[] arrayChar = str1.toCharArray();
        String str6 = String.join(" ", str1, str5);

        char сс = str1.charAt(1); // Извлечь сивмол
        System.out.println(сс);
        System.out.println(str6);
        System.out.println(arrayChar);
        System.out.println("Len: " + str1.length());
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
//        Вырезать промежуток символов
        String str7 = "Hello German ";
        int start = 6, end = 11;
        char[] dst=new char[end - start];
        str7.getChars(start, end, dst, 0);
        System.out.println(dst);
// Сравнить строки с учетом регистра
        System.out.println(str1.equals(str6));
// Без учета регистра
        System.out.println(str1.equalsIgnoreCase(str6));
//  Обрезка пробелов с права и с лева
        String str8 = new String();
        str8 = str7.trim();
        System.out.println(str8);
    }

    // Классы String buffer StringBuffer потокобезопасный, StringBuilder не потокобезопасный
    public static void main19(){
        String str = "Java";
        StringBuffer strBuffer = new StringBuffer(str);

        System.out.println("Емкость: " + strBuffer.capacity());
        strBuffer.ensureCapacity(32); // увеличиваем резервируемую емкость символов
        System.out.println("Емкость: " + strBuffer.capacity());
        System.out.println("Длина: " + strBuffer.length());

        char c = strBuffer.charAt(0); // Извлекаем первую букву
        strBuffer.setCharAt(0,'c'); // Вставляем на позицию сивмол
        System.out.println(strBuffer); // cava
    }

    //    Битовые операции и Или НЕ XOR
    public static void main20(){

        // Инверсия
        int var = 121; // 4 байт - 32 бит
        int not_var = ~var;
        System.out.println("Инверсия" + not_var);
        // И
        byte flags = 5;
        byte mask = 4;
        int res = flags&mask;
        System.out.println(res);

        if((flags&mask) == mask){
            System.out.println("Включен 2-й бит числа");
        }else {
            System.out.println("Не Включен 2-й бит числа");
        }
//      Включение отключение бита числа
        flags = (byte) (flags&~mask);
        System.out.println(flags);
//        ИЛИ
        flags = (byte) (flags | mask);
        System.out.println(flags);
    }

//    Перегрузка и Рекурсия
    static float perrimetr(float a, float b){
        float res = 2 * (a+b);
        return  res;
    }

    static void show_ar(byte[] ar){
        for(byte val : ar){
            System.out.println(val);
        }
    }
//    Произвольное число
    static void show_ar2(int ...ar){
        for(int val : ar){
            System.out.println(val);
        }
    }

    //    Перегрузка
    static int modul(int x){
        if(x<0) x = -x;
        return x;
    }

    //    Перегрузка
    static double modul(double x){
        return (x < 0) ? -x : x;
    }
//    рекурсия
    static void up_and_down(int n){
        System.out.println("Уровень вниз: " + n);
        if(n < 4) up_and_down(n +1);
        System.out.println("Уровень ввверх: " + n);

    }
    public static void main21(){
        float res = perrimetr(2,3);
        System.out.println(res);
        byte array[] = {1,3,0,-2,7,9};
        show_ar(array);
        show_ar2(1,2,3,54,5,6);
        int modulA1 = modul(-3);
        double modulA2 = modul(-3.5);
        System.out.println("Перегрузка: " +"Modul int: " + modulA1 + " Modul double: " + modulA2);
        up_and_down(1);
    }

}
