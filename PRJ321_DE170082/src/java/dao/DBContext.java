/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ321_DE170082;encrypt=false;";
    private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String username = "SA";
    private String password = "Manh@2003";
    
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
