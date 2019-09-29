/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class DB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //private static final String URL = "jdbc:mysql://localhost:3306/ebookshop";
    private static final String URL = "jdbc:mysql://cphbusinessmysql.mysql.database.azure.com:3306/ebookshop?useSSL=true&requireSSL=false&serverTimezone=UTC";
    private static final String USER = "dev@cphbusinessmysql";
    private static final String PASSWORD = "dev";
    
    public static Connection conn = null;
    
    public static Connection getConnection(){
        if(conn == null){
            try{
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }
    
}