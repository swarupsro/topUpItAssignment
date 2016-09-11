/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topupit.assignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author tahmid
 */
public class adminPanel extends javax.swing.JFrame {

    /**
     * Creates new form adminPanel
     */
    
    Connection connection;
    String dbName;
    String tableName;
    
    public adminPanel() {
        
        
        connection = databaseConnectivityWizard.getConnection();
        
        initComponents();
        
        

//        try {
//            movieStatusTable = null;
//            movieStatusTable = multiplexMoviesDatabase.retrieveDataTable();
//            jScrollPane1.add(movieStatusTable);
//
//            if (movieStatusTable == null) {
//                System.out.println("table null");
//            } else {
//                System.out.println("table added");
//            }
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }
    
    public adminPanel(String dbName, String tableName) {
        
        this.dbName = dbName;
        this.tableName = tableName;
        connection = databaseConnectivityWizard.getConnection();
        
        initComponents();
        
        

//        try {
//            movieStatusTable = null;
//            movieStatusTable = multiplexMoviesDatabase.retrieveDataTable();
//            jScrollPane1.add(movieStatusTable);
//
//            if (movieStatusTable == null) {
//                System.out.println("table null");
//            } else {
//                System.out.println("table added");
//            }
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 47, 54));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrator Dashboard", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 107, 107))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 205, 196));
        jLabel1.setText("Welcome Administrator");

        jLabel2.setForeground(new java.awt.Color(78, 205, 196));
        jLabel2.setText("Database: " + this.dbName);

        if (this.tableName.isEmpty()) {
            jTable3.setModel(new javax.swing.table.DefaultTableModel(
                multiplexMoviesDatabase.objectData(this.connection),
                multiplexMoviesDatabase.stringData(this.connection)
            ));
        } else {
            jTable3.setModel(new javax.swing.table.DefaultTableModel(
                multiplexMoviesDatabase.objectData(this.connection, this.tableName),
                multiplexMoviesDatabase.stringData(this.connection, this.tableName)
            ));
        }
        jScrollPane1.setViewportView(jTable3);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/topupit/assignment/network-administrator-128px.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(78, 205, 196));
        jLabel4.setText("Table: " + this.tableName);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(339, 339, 339)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}