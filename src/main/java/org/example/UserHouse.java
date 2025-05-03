package org.example;

import com.google.gson.JsonArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.SQLException;

import static org.example.DatabasePostgresql.connectToDatabase;
import static org.example.DatabasePostgresql.executeQueryJson;

import static org.example.UserKeys.checkPassword;

public class UserHouse extends UserKeys {
    // Создание логера
    private static final Logger logger = LogManager.getLogger(UserHouse.class);
    private static final String hashpassword = "0f27dda9ae120790a018399a2ec345b06844cbe59a0dc5ba145fe41020ddbd9a";
    private String password;

    private boolean access;

    public static String query() {
        Connection connection = connectToDatabase();
        String password = null;  // Инициализируем переменную для результата

        try {
            if (connection != null) {
                  JsonArray result = executeQueryJson(connection,
                    "SELECT password FROM userdb WHERE username = 'German' AND surname = 'Baklagin';");

                // Проверка, что результат не пустой
                if (result != null && result.size() > 0) {
                    password = result.get(0).getAsJsonObject().get("password").getAsString().trim();
                }
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
        return password;  // Возвращаем результат
    }

    public void House(String password) {

        String storedPassword = query();
        if(checkPassword(password, storedPassword)) {
            logger.info("Password House successful");
            access = true;
        }else{
            logger.info("Password House failed");
        }

    }


}
