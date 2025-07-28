package org.example;

public class MyThread2 extends Thread {
    MyThread2(){
        super("Demo Thread");
        System.out.println("Дочерний поток: " + this);

    }

    public void run(){
        try {
            for (int i = 5; i > 0 ; i--) {
                System.out.println("Дочерний поток");
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

}
