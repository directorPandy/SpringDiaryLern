package ru.director.SpringDiaryLern.connectionControllers;

import java.sql.*;

public class ConnectionModule {

    private final String url = "jdbc:postgresql://localhost/SpringDiary";
    private final String user = "postgres";
    private final String password = "Lortunib182";

    public Connection connect() {
       Connection connection = null;
        try {
             connection=  DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } return connection;
    }


}
