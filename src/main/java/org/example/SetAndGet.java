package org.example;

// Squate
/*
*   Сеттеры и Геттеры
* */
public class SetAndGet {

    private static final int MAX_COORD = 1000;
    private int x1, y1;
    private int x2, y2;

    SetAndGet() {}

    SetAndGet(int x1, int y1, int x2, int y2){
        if(isCorrect(x1) && isCorrect(x2)&& isCorrect(y1)&& isCorrect(y2)){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    int square(){
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    void setLeftTop(int x, int y){
        this.x1 = x;
        this.y1 = y;
    }

    private boolean isCorrect(int arg){
        return (0 <= arg && arg <= MAX_COORD);
    }

    public int getX1(){
        return x1;
    }
    public int getX2(){
        return x2;
    }
    public int getY1(){
        return y1;
    }
    public int getY2(){
        return y2;
    }
}
