package org.example;

public class lessons_1 {

    public static void main2() {
        int a = 1, b = 2;
        int res = a + b;
        System.out.println(res);

        int[] arr = {15, 27, 3, 344, 17};
        int summ = 0;
        for(int i: arr){
            summ += i;
        }
        System.out.println(summ /arr.length);
    }
}

