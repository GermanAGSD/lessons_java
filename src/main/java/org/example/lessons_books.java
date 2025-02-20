package org.example;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class lessons_books {
    public static void book_1() {
        Test test = new Test(100, 22);
        Test test2 = new Test(-1, -1);
        System.out.println(test.equlTo(test));
        System.out.println(test.equlTo(test2));

        List<Integer> spisok = new ArrayList<>();
        spisok.add(1);
        System.out.println(spisok);

        Set<Integer> sets = new HashSet<>();
        sets.add(1);
        sets.add(2);
        sets.add(1);
        System.out.println(sets);

        Map<String, Integer> maps = new HashMap<>();
        maps.put("German", 29);
        System.out.println(maps);

        Queue<String> queue = new LinkedList<>();
        queue.add("Task_1");
        System.out.println(queue);

        Test_2 test_2_2 = new Test_2(10, 10);
        System.out.println("test_2_2 a b" + test_2_2.a + " " + test_2_2.b);
        test_2_2.meth(test_2_2);
        System.out.println("test_2_2 a b" + test_2_2.a + " " + test_2_2.b);
    }

    public static void book_2() {
        Factorial f = new Factorial();
        System.out.println("Factorial: " + f.fact(3));

        String strob = "F";
        String strob2 = "F";
        System.out.println(strob.equals(strob2));
        System.out.println(strob.charAt(0));

        var t = new Test(100, 22);
        System.out.println(t.equlTo(t));


    }

    public static void book_3() {

        int sum = 1;
        try {
            sum = 1 + 2;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(sum);
        }

        try {
            riskyMethod(-1);
        } catch (ExceptionCustom e) {
            System.out.println("Поймано исключение: " + e);
        }

    }

    public static void riskyMethod(int number) throws ExceptionCustom {
        if (number < 0) {
            throw new ExceptionCustom(number);
        }
        System.out.println("Всё хорошо, число: " + number);
    }

    public static void book_4() {
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток: " + t);
        t.setName("My thread");
        System.out.println("Текущий поток: " + t);
        try{
            for (int i = 5; i >= 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Glab potok prervan");
        }
    }

    public static void book_5() {
        NewThread nt = new NewThread();
        nt.t.start();
        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Glab potok prervan");
        }
        System.out.println("Завершение главного потока");
    }
}

class Test {
    int a, b;

    Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    boolean equlTo(Test test) {
        if (test.a == a && test.b == b) {
            return true;
        } else {
            return false;
        }
    }
}

class Test_2 {
    int a, b;

    Test_2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void meth(Test_2 test) {
        test.a *= 2;
        test.b /= 2;
    }
}

class Factorial {
    int fact(int n) {
        if (n == 1) {
            return 1;
        }
        int res = fact(n - 1) * n;
        return res;
    }
}