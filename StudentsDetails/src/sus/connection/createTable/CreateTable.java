package sus.connection.createTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sus.connection.DbConnection;

public class CreateTable {
    public static void main(String[] args) {
        try {
            Connection con = DbConnection.getConnections("sus", "sus");
            String sql = "create table students("
                    + "student_id integer primary key,"
                    + "student_name varchar2(20) not null)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            System.out.println("Table is created....");
            pstm.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
