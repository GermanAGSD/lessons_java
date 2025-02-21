package org.example;

public class Caller {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme target, String s) {
        this.msg = s;
        this.target = target;
        this.t = new Thread();
    }

    public void run(){
        target.call(msg);
    }
}
