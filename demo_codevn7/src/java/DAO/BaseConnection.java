package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=demo_servlet;encrypt=true;trustServerCertificate=true;";
    // mysql
    // private String url = "jdbc:mysql://localhost:3306/[tendatabase]";
    private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // mysql
    // className = "com.mysql.cj.jdbc.Driver";
    private String username = "SA";// root
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
