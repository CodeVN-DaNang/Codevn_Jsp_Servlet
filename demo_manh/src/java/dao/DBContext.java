
package dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
  private String url = "jdbc:sqlserver://localhost:1433;databaseName=demo_manh;encrypt=true;trustServerCertificate=true;";
    private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String username = "SA";
    private String password = "Nhat@2102";
    
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
 