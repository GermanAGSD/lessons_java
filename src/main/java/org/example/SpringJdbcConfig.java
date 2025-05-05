package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan("com.test.jdbc")
public class SpringJdbcConfig {
    @Bean
    public DataSource postgresqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://172.30.30.19:5431/fastapi");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password123");
        return dataSource;
    }

    // Метод для создания JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(postgresqlDataSource());
    }
}