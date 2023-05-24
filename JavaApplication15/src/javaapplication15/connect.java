/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author 20106
 */
public class connect {
      private static String driverName = "com.mysql.jdbc.Driver";   
    private static Connection con;

 

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking_System", "root", "");
             
            } catch (SQLException ex) {
                // log an exception. fro example:
                                JOptionPane.showMessageDialog(null, "Failed to create the database connection.");

 

                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}
