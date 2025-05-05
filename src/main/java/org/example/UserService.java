package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
// Сервис для работы с данными
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Пример запроса, который получает все имена пользователей из таблицы "users"
    public List<String> getAllUsernames() {
        // Запрос
        String sql = "SELECT username FROM userdb";

        // Создание RowMapper для преобразования результатов запроса в список строк
        RowMapper<String> rowMapper = (resultSet, rowNum) -> resultSet.getString("username");

        // Выполнение запроса
        return jdbcTemplate.query(sql, rowMapper);
    }
}