/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topupit.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tahmid
 */
public class databaseUtility {
    
    static Connection connection;
    
    public static Connection retrieveConnection() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/multiplex", "root", "demoPassword");
        
        return connection;
    }
    
    public static Connection retrieveConnection(String dbName, String username, String password) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, username, password);
        
        return connection;
    }
    
    
}
