package com.hongchan.springbootmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class MySQLRunner implements ApplicationRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String sqlCreate = "CREATE TABLE USERS(ID INTEGER NOT NULL," +
                "NAME VARCHAR(255)," +
                "PRIMARY KEY(ID))";
        String sqlInsert = "INSERT INTO USERS VALUES (1, 'hongchan')";
        jdbcTemplate.execute(sqlCreate);
        jdbcTemplate.execute(sqlInsert);
    }
}
