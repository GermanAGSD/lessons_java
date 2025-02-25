package org.example;

class Tank {
    int x, y, dir, fuel;
    final static String model = "T34";
    static int nextNumber = 1; // Следующий номер для танка
    int number;              // Номер этого танка

    public Tank() {
        this.number = nextNumber++;
        this.x = 0;
        this.y = 0;
        this.fuel = 100;
    }

    public Tank(int x, int y) {
        this.number = nextNumber++;
        this.x = x;
        this.y = y;
        this.fuel = 100;
    }

    public Tank(int x, int y, int fuel) {
        this.number = nextNumber++;
        this.x = x;
        this.y = y;
        this.fuel = fuel;
    }

    public void goForward(int i) {
        if (i < 0 && -i > fuel)
            i = -fuel;
        else if (i > fuel)
            i = fuel;
        if (dir == 0)
            x += i;
        else if (dir == 1)
            y += i;
        else if (dir == 2)
            x -= i;
        else
            y -= i;
        fuel -= Math.abs(i);
    }

    public void printPosition() {
        System.out.println("The Tank " + model + "-" + number + " is at " + x + ", " + y + " now.");
    }

    public void turnLeft() {
        dir--;
        if (dir < 0)
            dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir > 3)
            dir = 0;
    }

    public void goBackward(int i) {
        goForward(-i);
    }
}
