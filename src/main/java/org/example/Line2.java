package org.example;

import java.util.Arrays;

public class Line2 extends Geoms implements Geometrical, GroupInterface.Interface_1{
   private int x1 ,x2, y1, y2;

    private boolean isCheck(int x){
        return (MIN_COODS <=  x && x <= MAX_COORDS);
    }
    void SetCoords(int x1, int x2, int y1, int y2){
        if(isCheck(x1) && isCheck(x2) && isCheck(y1) && isCheck(y2)){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }


    @Override
    void draw(double color) {
        if(Arrays.stream(GroupInterface.Interface_1.color).anyMatch(c -> c == color)){
            System.out.println("Цвет есть в коробке");
            System.out.println("Рисование фигуры цвет номер:" + color);
        }else {
            System.out.println("Нет такого цвета  в коробке:" + color);
        }

    }

    @Override
    public void method_1() {

    }
}
