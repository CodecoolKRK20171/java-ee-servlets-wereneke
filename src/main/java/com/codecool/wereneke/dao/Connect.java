package com.codecool.wereneke.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    //singleton design pattern to get single connection to database
    Connection connection;

    private Connect() {
        try {
            String url = "jdbc:sqlite:.//src/main/resources/db/future.db";
            this.connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connect instance = new Connect();

    public static Connection getConnection() {
        return instance.connection;
    }
}