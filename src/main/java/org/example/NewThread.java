package org.example;

public class NewThread implements Runnable {
    Thread t;
    NewThread() {
        t = new Thread(this, "New Thread");
        System.out.println("Дочерний поток");
    }


    @Override
    public void run() {
        try{
            for (int i = 5; i > 0 ; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("Дочерний поток interrupted");
        }
        System.out.println("Дочерний поток exiting");
    }
}
