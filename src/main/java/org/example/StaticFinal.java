package org.example;

public class StaticFinal {
    static int cnt;
    int x, y;

    static {
        cnt =0;
    }
    {
        x = y = -1;
    }

    StaticFinal() {
        cnt++;
    }

    public static int getCnt(){
        return cnt;
    }
}
