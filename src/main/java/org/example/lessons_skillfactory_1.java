package org.example;

import java.util.Stack;

public class lessons_skillfactory_1 {

    public static void skillFactroy() {
        int[] les = new int[] {1,2,3,4,75};
        MaxValue(les);
        MaxTwo(les);
    }

    public static void MaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void MaxTwo(int[] arr) {
        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > one) {
                two = one;
                one = arr[i];
            }else if (arr[i] > two) {
                two = arr[i];
            }
        }
        System.out.println(one + " : " + two);
    }

    public static void Stack() {
        CustomStack stack = new CustomStack(5);
        stack.push("Java");
        stack.push("Spring");
        stack.push("Microservice");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
