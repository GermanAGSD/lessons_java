package org.example;


import java.io.IOException;
import java.sql.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabasePostgresql {
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";

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

    public static void connectToDatabaseMethod_2() throws SQLException {

        String URL = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";
        Connection connection;
        List<String> list = new ArrayList<>();
//        connection = DriverManager.getConnection(URL);
        connection = DriverManager.getConnection(URL);
        try {
            Statement statement = connection.createStatement();
            System.out.println("Соедение с БД успешно");
            String query = "SELECT * from userdb";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(resultSet.getString("username"));
//                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("username");
                System.out.println("ID: " + ", Name: " + name);
            }
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            System.out.println("Соедение успешно закрыто");

        }
    }

    public static void DatabasePostgresqlConnection3() throws SQLException {
        List<String> list =  new ArrayList<>();
//        connection = DriverManager.getConnection(URL);
        try{
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            System.out.println("Соедение с БД успешно");
            System.out.println("Соедение успешно закрыто");
            String query = "SELECT * from userdb where username=?";
            // Подготавливаем запрос с параметром
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"German");  // Устанавливаем значение параметра (например, 'German')
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("username");  // Допустим, в таблице есть поле "name"
                list.add(data);  // Добавляем значение в список
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            connection.close();

        }
        System.out.println(list);
    }

    public static void DatabasePostgresqlConnection4(){
        String  USERNAME = "postgres"; // учетная запись пользователя
        String  PASSWORD = "password123"; // пароль

        List<LoadModel> data = new ArrayList<>();
        String url="jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";
        try (Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD)) {
            if (connection == null)
                System.err.println("Нет соединения с БД!");
            else {
                System.out.println("Соединение с БД установлено корректно");
                String SQL = "Select * from userdb;";
                //Запрос на получение всех данных
                try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            String i = resultSet.getString("username");
                            String i2 = resultSet.getString("password");
                            if (resultSet.wasNull()) {
                                System.out.println("NULL");
                            } else {
                                System.out.println(i);
                                System.out.println(i2);
                            }
                            //Добавляем каждый полученный элемент в наш лист
                            LoadModel loadModel = new LoadModel();
                            loadModel.i = String.valueOf(i);
                            data.add(loadModel);

                        }
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Iterator<LoadModel> iterator = data.iterator();
        while(iterator.hasNext()){
            LoadModel model = iterator.next();
            System.out.println(model);
        }
        System.out.println("Содержимое списка:");
        for (LoadModel model : data) {
            System.out.println(model); // Вызывается переопределённый метод toString()
        }
    }

/*
* Добавление столбца
* */
    public static void DatabasePostgresqlConnection5(String quaery) {
        String url = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";

        try (Connection connection = DriverManager.getConnection(url)) {
            if (connection == null) {
                System.err.println("Нет соединения с БД!");
            } else {
                System.out.println("Соединение с БД установлено.");
                String SQL = quaery; // Добавление столбца name
                try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                    preparedStatement.executeUpdate();
                    System.out.println("Столбец name успешно добавлен");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void DatabasePostgresqlConnection6() throws SQLException {
        // Строка для соединения с бд
        String url = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";
        connection = DriverManager.getConnection(url);
        try {
            connection.setAutoCommit(false);
            System.out.println("Соединение с БД установлено корректно");

            String SQL = "INSERT INTO userdb (username) VALUES (?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setString(1, "Olaf");
                preparedStatement.addBatch();

                preparedStatement.setString(1, "Erik");
                preparedStatement.addBatch();

                preparedStatement.setString(1, "Baleog");
                preparedStatement.addBatch();

                int[] count = preparedStatement.executeBatch();
                preparedStatement.clearBatch();
                connection.commit();
                System.out.println("Данные отправлены");
            }
        } catch (SQLException e) {
            connection.rollback();
            System.err.println("Данные не добавлены");
            e.printStackTrace();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static boolean checkvalue(String checkedvalue) throws SQLException {
        String Config = "jdbc:postgresql://172.30.30.19:5431/fastapi?user=postgres&password=password123";

        String SQL = "Select * from userdb where username=?;";
        Connection connection = DriverManager.getConnection(Config);
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, checkedvalue);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
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

