package com.codegym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/baithi";
    private static final String jdbcUser = "root";
    private static final String jdbcPass = "123123";

    protected static Connection getConnection() {

        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
            System.out.println("Success");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("failed");
        }

        return connection;
    }


//    public static void main(String[] args) {
//        Database
//    }
}
