package com.shamim.service;

import com.shamim.connection.DbConnection;
import com.shamim.domain.Students;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    Connection conn = DbConnection.getConnections("root", "root");

    public void insert(Students s) {
        try {
            String sql = "insert into students values(?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getStId());
            st.setString(2, s.getStName());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void update(Students s){
        try {
            String sql = "update students set st_name = ? where st_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, s.getStName());
            st.setInt(2, s.getStId());            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id){
        try {
            String sql = "delete from students where st_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Students> getStudents(){
        List<Students> list = new ArrayList<>();
        try {
            Students s;
            String sql = "select * from students order by st_id";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()==true){
                s = new Students(rs.getInt(1), rs.getString(2));
                list.add(s);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
