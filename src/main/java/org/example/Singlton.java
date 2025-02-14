package org.example;

public class Singlton {
    String message;
    private static Singlton instance;

    private Singlton() {}

    public static Singlton getInstance(){
        if(instance == null){
            instance = new Singlton();
        }
        return instance;
    }

    public void updateMessage(String mes){
        this.message = mes;
    }

    public void showMessage(){
        if(message == null){
            System.out.println("Singlton class: ");
        }else {
            System.out.println("Singlton class: " + message);
        }

    }
}
