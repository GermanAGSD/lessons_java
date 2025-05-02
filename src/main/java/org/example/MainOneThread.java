package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//public class MainOneThread {
//
//    public static void mainOne() {
//        long startTime = System.currentTimeMillis();
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i <= 1000000; i++) {
//            numbers.add(i);
//        }
//        int  max = Collections.max(numbers);
//        System.out.println("Max found " + max);
//
//        List<Integer> unsorted = new ArrayList<>();
//        for (int i = 1000000; i >= 1; i--) {
//            unsorted.add(i);
//        }
//        Collections.sort(unsorted);
//        System.out.println("Sorted in ascending order: " + unsorted);
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= 10000000; i++) {
//            list.add(i);
//        }
//        while (list.size() != 0) {
//            list.remove(list.size() - 1);
//        }
//        System.out.println("List cleared");
//
//        // Итог
//
//        long end = System.currentTimeMillis();
//
//        System.out.println("Total time: " + (end - start) + " ms");
//    }
//}
