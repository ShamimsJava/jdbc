package com.shamim.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccessConnection {
    public static Connection getAccessConnection(){
        String user = "";
        String pass = "";
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://D:\\Git\\Jdbc\\access\\Students.accdb", user, pass);
            System.out.println(":::Connected:::");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) {
        Connection con = AccessConnection.getAccessConnection();
    }
}
