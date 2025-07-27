package com.bms.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection getConnection() {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banksystem",
                "root",
                "root123"
        );
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }}
}
