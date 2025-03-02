package org.example;

public class ToLine {
    private int[][] data;

    public ToLine(int[][] data) {
        this.data = data;
    }

    // Метод преобразует двумерный массив в одномерный
    public int[] resize() {
        int rows = data.length;
        int cols = (rows > 0) ? data[0].length : 0;
        int[] result = new int[rows * cols];

        int index = 0;
        for (int[] row : data) {
            for (int value : row) {
                result[index++] = value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ToLine a = new ToLine(new int[][]{{1, 2}, {3, 4}, {5, 6}});
        int[] arr = a.resize();

        // Вывод одномерного массива
        System.out.println(java.util.Arrays.toString(arr));
    }
}