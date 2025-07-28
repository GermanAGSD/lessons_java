package org.example;

public class B extends A {
    int i;
    B(int a, int b){
        super.i = a;
        i = b;
    }
    void show(){
        System.out.println("i = " + super.i);
        System.out.println("i = " + i);
    }
}
