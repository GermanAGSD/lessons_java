package org.example;

public class Workester {

//
//    public static void libr_29() {
//        // Лямбда-выражение для интерфейса Lamda, которое возвращает число Пи
//        Lamda getpi = () -> 3.1415;
//        System.out.println("Pi: " + getpi.getValue());
//
//        // Лямбда-выражение для интерфейса Worker2
//        Worker2 work = (value, worker) -> worker.rework(value);
//
//        // Пример использования work
//        double result = work.doWork(5, (val) -> val * 2.5); // Умножаем значение на 2.5
//        System.out.println("Result of work: " + result);
//    }
//
//    // Интерфейс Lamda с методом getValue
//    @FunctionalInterface
//    interface Lamda {
//        double getValue();  // метод, который возвращает значение типа double
//    }
//
//    // Интерфейс Worker2 с методом doWork
//    @FunctionalInterface
//    interface Worker2 {
//        double doWork(int value, Worker worker);  // метод для работы с лямбдой Worker
//    }

    // Интерфейс Worker с методом rework
    @FunctionalInterface
    interface Worker {
        double rework(int value);  // метод для преобразования числа
    }

}
