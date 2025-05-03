package org.example;


import java.io.IOException;
import java.sql.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.sql.*;

public class DatabasePostgresql {

    // Метод для подключения к базе данных PostgreSQL
    public static Connection connectToDatabase() {
        try {
            // Укажите свой URL, пользователь и пароль для подключения
            String url = "jdbc:postgresql://172.30.30.19:5431/fastapi";
            String user = "postgres";
            String password = "password123";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
            return null;
        }
    }

    // Метод для выполнения SQL-запроса и получения результата в формате JSON
    public static JsonArray executeQueryJson(Connection connection, String query) {
        JsonArray resultArray = new JsonArray();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Получаем метаданные для результата
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                JsonObject row = new JsonObject();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = rs.getObject(i);
                    row.add(columnName, new Gson().toJsonTree(columnValue)); // Добавляем в JSON
                }
                resultArray.add(row); // Добавляем строку в массив
            }

        } catch (SQLException e) {
            System.err.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return resultArray;
    }

    // Пример метода для выполнения запроса и вывода результата
    // Метод для выполнения запроса и возврата результата
    public static JsonArray query(String query) {
        Connection connection = connectToDatabase();
        JsonArray result = null;  // Инициализируем переменную для результата

        try {
            if (connection != null) {
//                query = "SELECT * FROM hosts";
                result = executeQueryJson(connection, query);  // Получаем результат в переменную
            }
        } catch (Exception e) {
            System.err.println("Ошибка выполнения запроса: " + e.getMessage());
        } finally {
            // Гарантированно закрываем соединение
            if (connection != null) {
                try {
                    connection.close();  // Закрытие соединения с базой данных
                } catch (SQLException e) {
                    System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
                }
            }
        }
        return result;  // Возвращаем результат
    }

    // Метод для вставки хэшированного пароля в таблицу
    public static void insertUserToDatabase(String username, String surname, String password, String phone) {
        // Проверяем, что переданные значения не равны null
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }

        Connection connection = connectToDatabase();
        // Запрос для вставки имени пользователя и пароля в таблицу "users"
        String query = "INSERT INTO userdb (username, surname, password, phone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // Устанавливаем имя пользователя и пароль в запрос
            statement.setString(1, username);
            statement.setString(2, surname);
            statement.setString(3, password);
            statement.setString(4, phone);

            // Выполняем запрос
            statement.executeUpdate();
            System.out.println("User and password saved in the database.");
        } catch (SQLException e) {
            // Обрабатываем исключение при выполнении запроса
            throw new RuntimeException("Error inserting user and password into database", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();  // Закрываем соединение с базой данных
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

