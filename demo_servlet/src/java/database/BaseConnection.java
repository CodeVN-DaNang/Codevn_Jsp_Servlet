/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vannhat
 */
public class BaseConnection {

    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=qlcandidate;encrypt=true;trustServerCertificate=true;";
    private static String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String username = "SA";
    private static String password = "Nhat@2102";

    public static Connection getConnection() {
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
