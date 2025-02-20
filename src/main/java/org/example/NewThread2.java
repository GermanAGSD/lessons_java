package org.example;

public class NewThread2 extends Thread {
    NewThread2() {
        super("New Thread");
        System.out.println("Дочерний поток" + this);

    }

    public void run() {
        try{
            for (int i = 5; i > 0 ; i--) {
                System.out.println("Дочерний поток " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("Дочерний поток прерван");
        }
        System.out.println("Завершение дочернего потока");
    }

}
