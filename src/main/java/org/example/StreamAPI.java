package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class StreamAPI {
    public static void st() {
        // Асинхронно обрабатываем данные
        Stream<String> stream = Stream.of(
                "Первое сообщение",
                "Второе сообщение",
                "Третье сообщение");

        stream.forEach(message ->
                CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                })
        );
    }
}
