package com.shamim.service;

import com.shamim.dbconnection.DbConnection;
import com.shamim.domain.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressService {

    Connection con = DbConnection.getConnection();
    
    public void insert(Address a) {
        try {
            String sql = "insert into "
                    + "shamims_project.address_table(first_name, last_name, email_address, mobile_number, address) "
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, a.getFirstName());
            st.setString(2, a.getLastName());
            st.setString(3, a.getEmailAddress());
            st.setString(4, a.getMobileNumber());
            st.setString(5, a.getAddress());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ResultSet search(String name) {
        try {
            String sql = "select first_name, last_name, email_address, mobile_number, address "
                    + "from address_table "
                    + "where first_name = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
           return rs;    
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        try {
            AddressService as = new AddressService();
            ResultSet rs =  as.search("Shahin");
            
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
