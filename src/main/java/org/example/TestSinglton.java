package org.example;

public class TestSinglton {
    public void displayMessage() {
        // Получаем тот же экземпляр Singleton и выводим сообщение
        Singlton singleton = Singlton.getInstance();
        singleton.updateMessage("Update Works");
    }
}
