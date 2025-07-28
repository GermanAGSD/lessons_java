package org.example;

public class Rectangle extends Figure{

    Rectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public double getArea() {
        System.out.println("Area for Rectangle");
        return dim1 * dim2;
    }
}
