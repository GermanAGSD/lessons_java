package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.*;


public class SimpleHttpServer {

    private static final String URL = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";

    public static void server() throws IOException, SQLException {
        // Создаем HTTP сервер, который будет слушать на порту 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Регистрируем обработчик для URL "/"
        server.createContext("/user", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Выполнение запроса к базе данных и получение данных для пользователя
                User user = null;
                try (Connection connection = DriverManager.getConnection(URL)) {
                    String query = "SELECT username, password FROM userdb WHERE username = 'German'"; // Пример запроса
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    if (resultSet.next()) {
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        user = new User(username, password); // Создаем объект пользователя
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (user == null) {
                    // Если пользователь не найден, возвращаем ошибку
                    String errorResponse = "{\"error\": \"User not found\"}";
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
                    exchange.sendResponseHeaders(404, errorResponse.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(errorResponse.getBytes());
                    os.close();
                } else {
                    // Преобразование объекта user в JSON
                    Gson gson = new Gson();
                    String jsonResponse = gson.toJson(user);

                    // Отправляем JSON в ответе
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                    OutputStream os = exchange.getResponseBody();



                    os.write(jsonResponse.getBytes());
                    os.close();
                }
            }
        });
        // Регистрируем обработчик для URL "/"
        server.createContext("/users", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Создаем JsonArray для хранения пользователей
                JsonArray usersArray = new JsonArray();

                try (Connection connection = DriverManager.getConnection(URL)) {
                    String query = "SELECT username, password FROM userdb"; // Пример запроса для всех пользователей
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    // Чтение данных из базы и добавление в JsonArray
                    while (resultSet.next()) {
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");

                        JsonObject userJson = new JsonObject();
                        userJson.addProperty("username", username);
                        userJson.addProperty("password", password);

                        usersArray.add(userJson); // Добавляем объект в JsonArray
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // Если массив пользователей пустой, возвращаем ошибку
                if (usersArray.size() == 0) {
                    String errorResponse = "{\"error\": \"No users found\"}";
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
                    exchange.sendResponseHeaders(404, errorResponse.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(errorResponse.getBytes());
                    os.close();
                } else {
                    // Преобразуем JsonArray в строку JSON
                    Gson gson = new Gson();
                    String jsonResponse = gson.toJson(usersArray);

                    // Отправляем JSON в ответе
                    exchange.getResponseHeaders().add("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(jsonResponse.getBytes());
                    os.close();
                }
            }
        });
        // Запускаем сервер
        server.start();
        System.out.println("Server is listening on port 8000...");
    }
}
