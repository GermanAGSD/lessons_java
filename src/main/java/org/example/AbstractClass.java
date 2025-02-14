package org.example;

// Car
abstract class AbstractClass {
    String model;
    public abstract void go();
    public abstract void stop();
    public abstract void draw();

    public void setModel(String model){
        this.model = model;
    }
}

abstract class Geoms{
    double width, heigth,  color;
    abstract void draw(double color);
}

interface MathGeom{

    double getSquare(double height, double width);
}

interface GeomInterface{
    double[] getCoords();
}


class GeomFigure2 extends Geoms implements GeomInterface, MathGeom{
    double width, heigth;
    double color;
    @Override
    public double[] getCoords() {
        return new double[] {1,2,3,4};
    }

    @Override
    void draw(double color) {
        this.color = color;
    }

    @Override
    public double getSquare(double height, double width) {
        this.width = width;
        this.heigth = height;
        return 0;
    }
}

class GeomFigure extends Geoms implements MathGeom{
    double width;
    double height;


    @Override
    public double getSquare(double height,  double width) {
        this.width = width;
        this.height = height;
        return height * width;
    }

    @Override
    void draw(double color) {
        System.out.println("Рисование фигуры");
    }
}

class ToyotaCorolla extends AbstractClass{

    @Override
    public void go() {
        System.out.println("Тойота королла едет");
    }

    @Override
    public void stop() {
        System.out.println("Тойота королла остановилась");
    }

    @Override
    public void draw() {
        System.out.println("Рисование тойота королла");
    }
}

class ToyotaCamry extends AbstractClass{

    @Override
    public void go() {
        System.out.println("Тойота camry едет");
    }

    @Override
    public void stop() {
        System.out.println("Тойота camry остановилась");
    }

    @Override
    public void draw() {
        System.out.println("Рисование тойота camry");
    }
}
