package org.example;

public class Gen<T> {
    T ob;

    Gen(T o) {
        this.ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Типом Т является" + ob.getClass().getName());
    }
}
