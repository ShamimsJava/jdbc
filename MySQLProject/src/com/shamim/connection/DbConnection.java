package com.shamim.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306:sm", "root", "root");
            System.out.println(":::Connected:::");
            String sql = "insert into sm.students(student_id, student_name) values(104, 'Urmi')";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("1 row is inserted...");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
