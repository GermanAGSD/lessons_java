package org.example;

public class CallbackClass {
    public void exectask(CallbackInterface callbackInterface){
        System.out.println("Выполняется задача");
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }

        callbackInterface.onComplete(sum);
    }
}
