/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 20106
 */
public class ShowTransactions {
    
    
    public String[][] S_transactions(){
      String[][] data =new String[100][100];
        int row=0,col=0;
         
     String query = "SELECT * FROM transactions";
            try {
                PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                  data[row][col++]=rs.getString("info");
                  data[row][col++]=rs.getString("time");
                  data[row][col++]=rs.getString("user_id");
                  row++;
                  col=0;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failed connection");
            }
          return data; 
    }
}
