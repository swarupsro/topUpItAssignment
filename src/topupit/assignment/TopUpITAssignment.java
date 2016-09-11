/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topupit.assignment;

import java.sql.SQLException;

/**
 *
 * @author tahmid
 */
public class TopUpITAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
//            new multiplexMoviesDatabase();
            
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true);
            }
        });
            
        //}catch (ClassNotFoundException e) {
            //e.printStackTrace();
        //}catch (SQLException e) {
            //e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
