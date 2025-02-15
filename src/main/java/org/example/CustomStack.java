package org.example;

import java.util.EmptyStackException;

public class CustomStack {
    private String[] array;
    private int k;
    private int N;

    public CustomStack(int N){
        this.array = new String[N];
        this.k = -1;
    }

    public void push(String x){
        if(k == array.length - 1){
            throw new EmptyStackException();
        }
        array[++k] = x;
    }

    public String pop(){
        if(k == -1){
            throw new EmptyStackException();
        }
        var res = array[k];
        array[k] = null;
        k--;
        return res;
    }
}
