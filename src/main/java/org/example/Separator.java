package org.example;
import java.util.ArrayList;
import java.util.List;

public class Separator {
    private int[] array;

    public Separator(int[] array) {
        this.array = array;
    }

    // Метод возвращает массив четных чисел
    public int[] even() {
        List<Integer> evens = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        return evens.stream().mapToInt(Integer::intValue).toArray();
    }

    // Метод возвращает массив нечетных чисел
    public int[] odd() {
        List<Integer> odds = new ArrayList<>();
        for (int num : array) {
            if (num % 2 != 0) {
                odds.add(num);
            }
        }
        return odds.stream().mapToInt(Integer::intValue).toArray();
    }

}
