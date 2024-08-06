package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codevn
 */

import java.sql.*;

public class DBContext {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=demo_servlet;encrypt=true;trustServerCertificate=true;";
    private String username = "SA";
    private String password = "Nhat@2102";
    private String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection getConnection(){
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
