package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SimpleHttpServer {

    private static final String URL = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";

    public static void server() throws IOException, SQLException {
        // Создаем пул потоков с фиксированным количеством потоков
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        // Создаем HTTP сервер, который будет слушать на порту 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/hosts", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                executorService.submit(() -> {
                    // Создаем JsonArray для хранения пользователей
                    JsonArray usersArray = new JsonArray();

                    try (Connection connection = DriverManager.getConnection(URL)) {
                        String query = "SELECT ipadress FROM hosts"; // Пример запроса для всех пользователей
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);

                        // Чтение данных из базы и добавление в JsonArray
                        while (resultSet.next()) {
                            String ipadress = resultSet.getString("ipadress");

                            JsonObject ipadressJson = new JsonObject();
                            ipadressJson.addProperty("ipadress", ipadress);

                            usersArray.add(ipadressJson); // Добавляем объект в JsonArray
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    // Если массив пользователей пустой, возвращаем ошибку
                    if (usersArray.size() == 0) {
                        String errorResponse = "{\"error\": \"User not found\"}";
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        try {
                            exchange.sendResponseHeaders(404, errorResponse.getBytes().length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(errorResponse.getBytes());
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Преобразуем JsonArray в строку JSON
                        Gson gson = new Gson();
                        String jsonResponse = gson.toJson(usersArray);

                        // Отправляем JSON в ответе
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        try {
                            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(jsonResponse.getBytes());
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        // Регистрируем обработчик для URL "/user" GET
        server.createContext("/user", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                executorService.submit(() -> {
                    // Извлекаем параметр 'username' из URL запроса
                    String query = exchange.getRequestURI().getQuery();
                    String username = null;
                    String surname = null;

                    // Извлекаем параметры из query
                    if (query != null) {
                        for (String param : query.split("&")) {
                            String[] pair = param.split("=");
                            if (pair.length == 2) {
                                if (pair[0].equals("username")) {
                                    username = pair[1];
                                } else if (pair[0].equals("surname")) {
                                    surname = pair[1];
                                }
                            }
                        }
                    }
//                    If 1 parametr
//                    if (query != null && query.contains("username=")) {
//                        username = query.split("username=")[1];
//                    }

                    // Создаем JsonArray для хранения пользователей
                    JsonArray usersArray = new JsonArray();

                    try (Connection connection = DriverManager.getConnection(URL)) {
                        // Используем подготовленный запрос с параметром
                        String sql = "SELECT username, password, surname, phone FROM userdb WHERE username = ? AND surname = ?"; // Пример запроса с параметром
                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setString(1, username); // Устанавливаем значение параметра
                            statement.setString(2, surname); // Устанавливаем значение параметра
                            try (ResultSet resultSet = statement.executeQuery()) {
                                while (resultSet.next()) {
                                    String dbUsername = resultSet.getString("username");
                                    String password = resultSet.getString("password");
                                    String surname2 = resultSet.getString("surname");
                                    String phone = resultSet.getString("phone");

                                    JsonObject userJson = new JsonObject();
                                    userJson.addProperty("username", username);
                                    userJson.addProperty("password", password);
                                    userJson.addProperty("surname", surname2);
                                    userJson.addProperty("phone", phone);
                                    usersArray.add(userJson);
                                }
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    // Если массив пользователей пустой, возвращаем ошибку
                    if (usersArray.size() == 0) {
                        String errorResponse = "{\"error\": \"User not found\"}";
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        try {
                            exchange.sendResponseHeaders(404, errorResponse.getBytes().length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(errorResponse.getBytes());
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Преобразуем JsonArray в строку JSON
                        Gson gson = new Gson();
                        String jsonResponse = gson.toJson(usersArray);

                        // Отправляем JSON в ответе
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        try {
                            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(jsonResponse.getBytes());
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        // Регистрируем обработчик для URL "/" GET
        server.createContext("/users", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                executorService.submit(() -> {
                    // Создаем JsonArray для хранения пользователей
                    JsonArray usersArray = new JsonArray();

                    try (Connection connection = DriverManager.getConnection(URL)) {
                        String query = "SELECT username, password, phone, surname FROM userdb"; // Пример запроса для всех пользователей
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);

                        // Чтение данных из базы и добавление в JsonArray
                        while (resultSet.next()) {
                            String username = resultSet.getString("username");
                            String password = resultSet.getString("password");
                            String surname = resultSet.getString("surname");
                            String phone = resultSet.getString("phone");


                            JsonObject userJson = new JsonObject();
                            userJson.addProperty("username", username);
                            userJson.addProperty("password", password);
                            userJson.addProperty("surname", surname);
                            userJson.addProperty("phone", phone);


                            usersArray.add(userJson); // Добавляем объект в JsonArray
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    // Если массив пользователей пустой, возвращаем ошибку
                    if (usersArray.size() == 0) {
                        String errorResponse = "{\"error\": \"User not found\"}";
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        try {
                            exchange.sendResponseHeaders(404, errorResponse.getBytes().length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(errorResponse.getBytes());
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Преобразуем JsonArray в строку JSON
                        Gson gson = new Gson();
                        String jsonResponse = gson.toJson(usersArray);

                        // Отправляем JSON в ответе
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        try {
                            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(jsonResponse.getBytes());
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        // Регистрируем обработчик для URL "/addUser" (POST)
        server.createContext("/addUser", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Обработка запроса в отдельном потоке
                executorService.submit(() -> {
                    if ("POST".equals(exchange.getRequestMethod())) {
                        try {
                            // Получаем тело запроса (JSON данные)
                            InputStreamReader reader = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                            BufferedReader bufferedReader = new BufferedReader(reader);
                            StringBuilder requestBody = new StringBuilder();
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                requestBody.append(line);
                            }

                            // Преобразуем тело запроса (JSON) в объект с помощью Gson
                            Gson gson = new Gson();
                            JsonObject userJson = gson.fromJson(requestBody.toString(), JsonObject.class);

                            String username = userJson.get("username").getAsString();
                            String password = userJson.get("password").getAsString();
                            String surname = userJson.get("surname").getAsString();
                            String phone = userJson.get("phone").getAsString();

                            // Хэшируем пароль
                            String hashedPass = UserKeys.generateSHA256Hash(password);

                            // Подключаемся к базе данных и выполняем запрос
                            try (Connection connection = DriverManager.getConnection(URL)) {
                                String sql = "INSERT INTO userdb (username, password, surname, phone) VALUES (?, ?, ?, ?)";
                                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                                    statement.setString(1, username);
                                    statement.setString(2, hashedPass);
                                    statement.setString(3, surname);
                                    statement.setString(4, phone);

                                    int rowsAffected = statement.executeUpdate();

                                    // Если данные успешно добавлены, отправляем успех
                                    if (rowsAffected > 0) {
                                        String successResponse = "{\"message\": \"User added successfully\"}";
                                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                                        exchange.sendResponseHeaders(200, successResponse.getBytes().length);
                                        OutputStream os = exchange.getResponseBody();
                                        os.write(successResponse.getBytes());
                                        os.close();
                                    } else {
                                        String errorResponse = "{\"error\": \"Failed to add user\"}";
                                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                                        exchange.sendResponseHeaders(400, errorResponse.getBytes().length);
                                        OutputStream os = exchange.getResponseBody();
                                        os.write(errorResponse.getBytes());
                                        os.close();
                                    }
                                }
                            } catch (SQLException e) {
                                String errorResponse = "{\"error\": \"Database error\"}";
                                exchange.getResponseHeaders().add("Content-Type", "application/json");
                                exchange.sendResponseHeaders(500, errorResponse.getBytes().length);
                                OutputStream os = exchange.getResponseBody();
                                os.write(errorResponse.getBytes());
                                os.close();
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Если не POST-запрос, возвращаем ошибку
                        String errorResponse = "{\"error\": \"Invalid request method\"}";
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        try {
                            exchange.sendResponseHeaders(405, errorResponse.getBytes().length);
                            OutputStream os = exchange.getResponseBody();
                            os.write(errorResponse.getBytes());
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        // Запускаем сервер
        server.start();
        System.out.println("Server is listening on port 8000...");
    }
}
