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
}
