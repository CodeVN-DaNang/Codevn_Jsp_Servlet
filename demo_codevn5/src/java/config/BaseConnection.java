/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vannhat
 */
public class BaseConnection {
    // url = "jdbc:sqlserver://**servername**\\**intanceName**:1433;databaseName=**tendb**;encrypt=true;trustServerCertificate=true;";
    // className = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    // username = "**username**"
    // password = "**password**"
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=demo_codevn5;encrypt=true;trustServerCertificate=true;";
    private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String username = "SA";
    private String password = "Nhat@2102";

    public Connection getConnection() {
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
