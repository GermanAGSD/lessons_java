package org.example;

public class ExceptionCustom extends Exception {
    private int detail;

    public ExceptionCustom() {}

    public ExceptionCustom(int a) {
        this.detail = a;
    }

    public String toString(){
        return "Custom Exception: " + detail;
    }
}
