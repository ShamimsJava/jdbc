package com.shamim.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private static final String HOST = "jdbc:mysql://localhost";
    private static final String PORT = "3306";
    private static Connection connection;
    private static String url = HOST + ":" + PORT;
    
    public static Connection getConnections(String dbUserName, String dbPass){
        try {
            connection = DriverManager.getConnection(url, dbUserName, dbPass);
            System.out.println(":::::Connected:::::");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void main(String[] args) {
        Connection conn = MysqlConnection.getConnections("root", "root");
        System.out.println(":::Connected:::");
    }
}
