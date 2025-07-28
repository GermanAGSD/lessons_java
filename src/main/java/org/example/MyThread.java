package org.example;

public class MyThread implements Runnable {

    Thread t;
    MyThread(){
        t = new Thread(this);
        System.out.println("MyThread started");
    }
    @Override
    public void run() {
        try {
            for (int i = 5; i > 5 ; i--) {
                System.out.println("MyThread started");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
