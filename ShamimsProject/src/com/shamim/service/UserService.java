package com.shamim.service;

import com.shamim.dbconnection.DbConnection;
import com.shamim.domain.UserClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    
    Connection con = DbConnection.getConnection();

    public void insert(UserClass u) {
        try {
            String sql = "insert into user_table"
                    + "(first_name, last_name, email, user_name, user_password) "
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, u.getFirstName());
            st.setString(2, u.getLastName());
            st.setString(3, u.getEmail());
            st.setString(4, u.getUserName());
            st.setString(5, u.getPassword());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public UserClass getLogin(String userName){
        UserClass uc = new UserClass();
        try {
            String sql = "select user_name, user_password from user_table where user_name = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {               
                uc.setUserName(rs.getString(1));
                uc.setPassword(rs.getString(2));
            }           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uc;
    }
}
