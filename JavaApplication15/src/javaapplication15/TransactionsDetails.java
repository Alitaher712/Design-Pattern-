/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 20106
 */
public class TransactionsDetails {
    customer cus=customer.get_instance();
    public String[][] display(){
        String[][] data =new String[100][100];
      
        int row=0,col=0;
        
          String query = "SELECT * FROM transactions where user_id=?";
            try {

                PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query);
                ps.setString(1,Integer.toString(cus.getUser_id()));
              
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    data[row][col++] = Integer.toString(rs.getInt("user_id"));
                    data[row][col++] = rs.getString("info");
                    data[row][col++] = rs.getString("time");
                    row++;
                    col=0;
                 
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failed connection");
            }
           
       return data;
    }
}
