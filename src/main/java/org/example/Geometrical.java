package org.example;

public interface Geometrical {
    int MIN_COODS = 0;
    int MAX_COORDS = 1000;

    static void showInterval(){
        System.out.println("Interval od: " + MIN_COODS + " do: " + MAX_COORDS);
    }
}

class GroupInterface{

    interface Interface_1{
        double[] color = {1,2,3,4,5.0};
        void method_1();

    }

    interface Interface_2{
        void method_2();
    }
}