package sus.connection.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sus.connection.DbConnection;
import sus.connection.dao.StudentDao;
import sus.connection.domain.Students;

public class StudentService implements StudentDao {

    Connection con = DbConnection.getConnections("sus", "sus");

    @Override
    public void insert(Students s) {
        try {
            String sql = "insert into students values(?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, s.id);
            stmt.setString(2, s.studentName);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Students s) {
        try {
            if (s.id != 0) {
                String sql = "update students set student_name = ? where student_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, s.studentName);
                stmt.setInt(2, s.id);
                stmt.executeUpdate();
                stmt.close();
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            if (id != 0) {
                String sql = "delete from students where student_id = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                stmt.close();
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Students> getStudents() {
        List<Students> list = new ArrayList<>();
        try {
            Students s;
            String sql = "select * from students";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                s = new Students(rs.getInt(1), rs.getString(2));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Students getStudent(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
