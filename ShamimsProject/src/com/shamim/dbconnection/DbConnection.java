package com.shamim.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static String url = "jdbc:mysql://localhost/shamims_project";
    private static String user = "root";
    private static String password = "root";
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        getConnection();
        System.out.println(":::::Connected:::::");
    }
}
