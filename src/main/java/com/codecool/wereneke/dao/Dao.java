package com.codecool.wereneke.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    static Connection connection = Connect.getConnection();

    public String getFuture(int index) throws SQLException{

        String future;
        Statement stmt = connection.createStatement();
        String sql = String.format("SELECT future FROM future WHERE id=%d;", index);
        future = stmt.executeQuery(sql).getString("future");
        stmt.close();
        connection.commit();
        return future;
    }
}
