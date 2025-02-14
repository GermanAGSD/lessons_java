package org.example;

public class Line extends Properties {
    double x1, y1;
    double x2, y2;

    public Line(){
        super(0,0);
        System.out.println("Конструктор Line");
    }

    public void Show_id(){
        System.out.println("id: " + id + " super.id = " + super.id);
    }

    // Метод переопределен
    @Override
    public void draw(){
        System.out.println("Рисование линии");
    }
}
