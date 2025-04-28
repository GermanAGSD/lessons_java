package org.example;

public class Mathematics {
    int a , b, c;
    int x1, x2;
    int decriminant;

    Mathematics() {}
    public double descriminant(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
        this.decriminant = decriminant;
        decriminant = (b * b) - 4 * (a * c);
        return decriminant;
    }

    public void toPrint(){
        System.out.println(decriminant);
    }

    public double korni(){
        return 1;
    }

    public static double abs(double num) {
        // Напишите здесь свой код
        return Math.abs(num);
    }

    public static int max(int a, int b) {
        // Напишите здесь свой код
        return Math.max(a, b);
    }

    public static int min(int a, int b) {
        // Напишите здесь свой код
        return Math.min(a, b);
    }

}
