package org.example;

import java.util.NoSuchElementException;

public class CustomQueue {
    private String[] array;
    private int head;
    private int tail;

    public CustomQueue(int N) {
        this.array = new String[N];

    }

    public void enqueue(String item) {
        if(tail == array.length-1) {
            throw new NoSuchElementException();
        }
        array[++tail] = item;

    }

    public String dequeue() {
        if(head == tail) {
            throw new NoSuchElementException();
        }
        var res = array[head];
        array[head] = null;
        head++;
        return res;
    }
}
