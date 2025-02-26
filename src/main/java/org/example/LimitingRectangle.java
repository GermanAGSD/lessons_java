package org.example;

import java.util.Arrays;

public class LimitingRectangle {
    private int[][] points;
    private int minX, maxX, minY, maxY;

    public LimitingRectangle(int[][] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException("Массив точек не может быть пустым.");
        }
        this.points = points;
        calculateBorders();
    }

    // Метод вычисляет границы прямоугольника
    private void calculateBorders() {
        minX = maxX = points[0][0];
        minY = maxY = points[0][1];

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }
    }

    public int getWidth() {
        return maxX - minX;
    }

    public int getHeight() {
        return maxY - minY;
    }

    public String getBorders() {
        return minY + ", " + maxY + ", " + minX + ", " + maxX;
    }

}
