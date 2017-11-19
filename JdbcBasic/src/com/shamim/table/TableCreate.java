package com.shamim.table;

import com.shamim.connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TableCreate {
    public static void main(String[] args) {
        try {
            Connection conn = DbConnection.getConnections("root", "root");
            String sql = "create table students2("
                    + "st_id integer(5) primary key,"
                    + "st_name varchar(15) not null)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("::::Table is created::::");
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
