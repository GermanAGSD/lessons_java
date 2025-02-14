package org.example;

class Point {

    int x, y;
    int color;

//    иницлизатор
    {
        x = -1; y = -1;
        color = 100;
    }

    Point(){}

    Point(int x, int y){
        this.x = x;
        this.y = y;
        color = 0;
    }


}
