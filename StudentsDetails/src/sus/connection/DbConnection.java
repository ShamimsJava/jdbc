package sus.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection{
    static Connection conn;
    public static Connection getConnections(String user, String password){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        DbConnection.getConnections("sus", "sus");
        System.out.println(":::Connected:::");
    }
}