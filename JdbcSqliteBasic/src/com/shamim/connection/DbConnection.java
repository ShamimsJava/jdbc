package com.shamim.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static String url = "jdbc:sqlite:C:/sqlite/test.db";
    private static Connection connection;

    public static Connection getConnections() {
        try {    
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = DbConnection.getConnections();
        System.out.println(":::::Connected:::::");
    }
}

/*
For Oracle Database Enterprise Edition:
---------------------------------------
private static String driver = "oracle.jdbc.driver.OracleDriver";
private static String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // orcl is service id (sid)

For Oracle Database Express Edition:
------------------------------------
private static String driver = "oracle.jdbc.driver.OracleDriver";
private static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // xe is service id(sid)

For Mysql Database:
-------------------
private static String driver = "com.mysql.jdbc.Driver";
private static String url = "jdbc:mysql://localhost:3306/sample"; //sample is schema name
*/
