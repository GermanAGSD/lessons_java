package PractiesSkillfactory_7;

public abstract class Quadrangle {
    int a, b;
    String color;

    Quadrangle(int a, int b, String color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }

    public abstract double getLargeDiagonal();
    public abstract double getHeight();
    public abstract String getColor();

}
