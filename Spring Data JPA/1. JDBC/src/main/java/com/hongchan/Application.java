package com.hongchan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "hongchan";
        String password = "pass";

        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println(connection);
            String sql = "INSERT INTO ACCOUNT VALUES (1, 'hongchan', 'pass');";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        }
    }
}
