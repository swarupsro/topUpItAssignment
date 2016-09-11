/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topupit.assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author tahmid
 */
public class multiplexMoviesDatabase {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static ResultSetMetaData resultSetMetaData;
    private static JTable jTable;
    
    private static String tableName;

    static Object data[][];
    static String dataString[][];
    static Object column[];
    static String columnString[];

    public multiplexMoviesDatabase() throws ClassNotFoundException, SQLException {

        connection = databaseUtility.retrieveConnection();
        multiplexMoviesDatabase.tableName = "movies";
        
        if (connection != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Failed to connect Database");
        }

        retrieveDataFromDatabase();
    }
    
    public multiplexMoviesDatabase(Connection connection) throws ClassNotFoundException, SQLException {

        this.connection = connection;
        multiplexMoviesDatabase.tableName = "movies";
        
        if (this.connection != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Failed to connect Database");
        }

        retrieveDataFromDatabase();
    }
    
    public multiplexMoviesDatabase(Connection connection, String tableName) throws ClassNotFoundException, SQLException {

        this.connection = connection;
        multiplexMoviesDatabase.tableName = tableName;

        if (connection != null) {
            System.out.println("Connection Successful");
        } else {
            System.out.println("Failed to connect Database");
        }

        retrieveDataFromDatabase();
    }

    public static void retrieveDataFromDatabase() throws SQLException {

        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM " + multiplexMoviesDatabase.tableName);
        resultSetMetaData = resultSet.getMetaData();

        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println(resultSetMetaData.getColumnName(i));
        }
        System.out.println("=====================================\n\n");

        resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + multiplexMoviesDatabase.tableName);
        resultSet.next();
        int rowCount = resultSet.getInt(1);

        resultSet = statement.executeQuery("SELECT * FROM " + multiplexMoviesDatabase.tableName);
        resultSetMetaData = resultSet.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();
        int indexManager = 0;

        column = new Object[columnCount];
        columnString = new String[columnCount];

        for (int i = 1; i <= columnCount; i++) {

            column[indexManager] = resultSetMetaData.getColumnName(i);
            columnString[indexManager] = resultSetMetaData.getColumnName(i);
            indexManager++;
        }

        data = new Object[rowCount][columnCount];
        dataString = new String[rowCount][columnCount];

        int rowManager = 0;
        int columnManager = 0;

        while (resultSet.next()) {

            columnManager = 0;

            for (int i = 1; i <= columnCount; i++) {
                data[rowManager][columnManager] = resultSet.getString(i);
                dataString[rowManager][columnManager] = resultSet.getString(i);
                columnManager++;
            }
            rowManager++;
        }

//        for (int i = 0; i < column.length; i++) {
//
//            System.out.print(column[i] + " ---- ");
//        }
//        System.out.println();
//
//        for (int i = 0; i < rowCount; i++) {
//
//            for (int j = 0; j < columnCount; j++) {
//                System.out.print("" + data[i][j] + " ---- ");
//            }
//            System.out.println();
//        }
    }

    public static Object[][] objectData() {

        try {
            new multiplexMoviesDatabase();

            Object[][] x = multiplexMoviesDatabase.data;

            return x;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;

    }
    
    public static Object[][] objectData(Connection connection) {

        try {
            new multiplexMoviesDatabase(connection);

            Object[][] x = multiplexMoviesDatabase.data;

            return x;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(multiplexMoviesDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(multiplexMoviesDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

    }

    public static Object[][] objectData(Connection connection, String tableName) {

        try {
            new multiplexMoviesDatabase(connection, tableName);

            Object[][] x = multiplexMoviesDatabase.data;

            return x;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;

    }
    
    public static String[] stringData() {

        try {
            new multiplexMoviesDatabase();
            String[] x = multiplexMoviesDatabase.columnString;

            return x;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(multiplexMoviesDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(multiplexMoviesDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public static String[] stringData(Connection connection) {

        try {
            new multiplexMoviesDatabase(connection);
            String[] x = multiplexMoviesDatabase.columnString;

            return x;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(multiplexMoviesDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(multiplexMoviesDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public static String[] stringData(Connection connection, String tableName) {

        try {
            new multiplexMoviesDatabase(connection, tableName);
            String[] x = multiplexMoviesDatabase.columnString;

            return x;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return null;
    }
}
