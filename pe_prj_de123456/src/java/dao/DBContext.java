/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author codevn
 */
public class DBContext {
private String url = "jdbc:sqlserver://localhost:1433;databaseName=books_de678909;encrypt=true;trustServerCertificate=true;";
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
