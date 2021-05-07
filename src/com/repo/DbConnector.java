package com.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    public static String sqliteConn = "jdbc:sqlite:javaConsoleDb.db";

    public Connection Connect(){

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(sqliteConn);
            System.out.println("Connected to Db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

}
