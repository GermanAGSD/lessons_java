package org.example;


import java.sql.*;
public class DatabasePostgresql {
    // Параметры подключения

    // Функция для подключения к базе данных PostgreSQL
    public static Connection connectToDatabase() {
        String url = "jdbc:postgresql://172.30.30.19:5431/fastapi";
        String user = "postgres";
        String password = "password123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Подключение к базе данных выполнено успешно.");
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
        return connection;
    }

    // Функция для выполнения SQL-запроса
    // Функция для выполнения SQL-запроса
    public static void executeQuery(Connection connection, String query) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                // Обработка результата запроса (пример)
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения SQL-запроса: " + e.getMessage());
        }
    }

    // Функция для выполнения SQL-запроса и сериализации результата в JSON

}
