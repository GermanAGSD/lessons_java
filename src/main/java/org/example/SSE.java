package org.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SSE {

    public static void server() throws Exception {
        // Создаём HTTP сервер на порту 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/sse", new SseHandler()); // Обработчик для /sse
        server.setExecutor(null); // Используем дефолтный executor
        server.start();
        System.out.println("SSE сервер запущен на порту 8080...");
    }

    // Обработчик для SSE
    static class SseHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Устанавливаем заголовки для SSE
            exchange.getResponseHeaders().add("Content-Type", "text/event-stream");
            exchange.getResponseHeaders().add("Cache-Control", "no-cache");
            exchange.getResponseHeaders().add("Connection", "keep-alive");

            // Устанавливаем код состояния для успешного ответа
            exchange.sendResponseHeaders(200, 0);

            OutputStream os = exchange.getResponseBody();
            // Эмулируем отправку событий каждые 5 секунд
            for (int i = 0; i < 5; i++) {
                String message = "data: Сообщение " + (i + 1) + "\n\n"; // Формат сообщения SSE
                os.write(message.getBytes());
                os.flush();
                try {
                    Thread.sleep(5000); // Пауза 5 секунд
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Закрываем поток ответа
            os.close();
        }
    }
}
