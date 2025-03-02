package org.example;

public class ToTable {
    int data[];
    int x;
    int y;

    ToTable(int[] data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    public int[][] resize(){
        int[][] table = new int[x][y];
        int index = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                table[i][j] = data[index++];
            }
        }
        return table;
    }
}
