package org.example;

abstract class Figure {
    double dim1, dim2;

    Figure(double x, double y) {
        dim1 = x;
        dim2 = y;
    }

    abstract public double getArea();

}
