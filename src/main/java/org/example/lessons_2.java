package org.example;

public class lessons_2 {
    public static void main8() {
        int x = 5;
        // без типа данных, при иницилизация тип ставиться автоматически
        var y = 10;
        // Константа не изменяема
        final int t = 10;
        boolean u = true;
        byte o = 127;
        short s = 32000;
        int e = 2_000_000;
        long w = 2323L;
        double as = 32324.00;
        float er = 23f;
        char z = 'a';

        double d1 = 0.1;
        double d2 = 0.7;
        System.out.println(d1 + d2); // 0.7999999999

        int a1 = 5;
        int a2 = 10;

        System.out.println(a1+=a2); // 15
    }

    public static void main9(String[] args) {

    }
}
