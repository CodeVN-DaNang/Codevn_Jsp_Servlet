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
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=[ten_database];encryp=false;";
    private String username = "[username]";
    private String password = "[password]";
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
