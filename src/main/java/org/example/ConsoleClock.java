package org.example;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalTime;

public class ConsoleClock extends Thread {
    @Override
    public void run() {

        try{
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            // Получаем текущее время с помощью Calendar
            while (!isInterrupted()) {


                Calendar calendar = Calendar.getInstance();

                // Форматируем время в строку
                String currentTime = dateFormat.format(calendar.getTime());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("The clokck was stopped");
        }
    }
}
