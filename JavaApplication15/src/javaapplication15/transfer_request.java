/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 20106
 */
public class transfer_request {
    
    public void transfer(int id , int amount){
      
       Transaction_facade facade =new Transaction_facade();
        facade.withdraw(amount);
        
         int balance = 0;
   
    Connection con = null;

        PreparedStatement p = null;

        con = connect.getConnection();

         String query = "SELECT balance FROM accounts where user_id=? ";
            try {

                PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query);
                ps.setString(1, Integer.toString(id));
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    balance = rs.getInt("balance");
                   
                }

            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failed connection");
            }
          
        try {
             int res=balance+amount;
           String sql = "UPDATE accounts SET balance = "+res+" WHERE user_id = "+id;

            p = con.prepareStatement(sql);

            p.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        
    }
}
