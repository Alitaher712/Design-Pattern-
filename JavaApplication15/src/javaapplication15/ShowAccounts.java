/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 20106
 */
public class ShowAccounts {
    public String [][] show_acc(){
         String[][] data =new String[100][100];
         int row=0,col=0;
          
         String query = "SELECT * FROM accounts INNER JOIN users ON (accounts.user_id=users.user_id)";
            try {
             
                PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    data[row][col++] = Integer.toString(rs.getInt("user_id"));
                    data[row][col++] = rs.getString("user_name");
                    data[row][col++] = rs.getString("SSN");
                    data[row][col++] = Integer.toString(rs.getInt("age"));
                    data[row][col++] = rs.getString("gender");
                    data[row][col++] = rs.getString("account_type");
                    data[row][col++] = Integer.toString(rs.getInt("balance"));
                    row++;
                    col=0;
                  //  System.out.println("2");
                }

            } 
              catch (SQLException ex) {
                System.out.println(ex);
                //JOptionPane.showMessageDialog(null, "Failed connection");
            }
            return data;
    }
    
}
