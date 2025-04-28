package org.example;

public class Crate<T> {
    private T contents;
    public Crate(T contents) {
        this.contents = contents;
    }

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }
}