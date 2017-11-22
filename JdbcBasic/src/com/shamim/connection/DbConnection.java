package com.shamim.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static Connection connection;

    public static Connection getConnections(String user, String password) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = DbConnection.getConnections("root", "root");
        System.out.println(":::::Connected:::::");
    }
}

/*
User creation:
--------------
create user sus identified by sus;
grant dba to sus;
conn sus/sus;

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
