package org.example;

public class Properties extends Geom{
    protected int id = 1;
    int width, color;

    public Properties() {
        System.out.println("Конструктор Properties");
    }

    public Properties(int width, int color){
        this.width = width;
        this.color = color;
        System.out.println("Конструктор Properties( width, color )");
    }

    void draw(){
        System.out.println("Этот метод следует переопределить");
    }
}
