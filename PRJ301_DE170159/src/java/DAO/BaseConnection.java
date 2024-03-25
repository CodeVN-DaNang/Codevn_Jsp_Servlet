/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import java.sql.*;

/**
 *
 * @author codevn
 */
public class BaseConnection {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ301_DE170159;encrypt=true;trustServerCertificate=true;";
    private String username = "SA";
    private String password = "Nhat@2102";
    private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection getConnection(){
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
