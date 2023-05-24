/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author 20106
 */
public class RespondLoanRequests {

    public void respond(int loan_id, String Status) {
        int cust_id = 0, amount = 0;
        boolean flag = false;
        Connection con = null;
        PreparedStatement p = null;
        con = connect.getConnection();
       
        
        String query3 = "SELECT * FROM loans where loan_id=? and loan_status=?";
        try {
           PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query3);
            ps.setString(1, Integer.toString(loan_id));
            ps.setString(2, " Pending");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed connection");
        }
        if (flag) {
            try {
                String sql = "UPDATE loans SET loan_status = '" + Status + "' WHERE loan_id = " + loan_id;
                p = con.prepareStatement(sql);
                p.execute();
                JOptionPane.showMessageDialog(null, "Loan " + Status);
            } catch (SQLException e) {
                System.out.println(e);
            }

            String des;
            try {

                String query2 = "SELECT * FROM loans where loan_id=?";
                try {
                    PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query2);
                    ps.setString(1, Integer.toString(loan_id));
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {

                        cust_id = rs.getInt("user_id");
                        amount = rs.getInt("amount");

                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed connection");
                }

                des = "Loan request transaction occured from " + Integer.toString(cust_id) + " with amount of" + Integer.toString(amount) + " is " + Status;
                String insertquery = "INSERT INTO transactions(info, time,user_id) VALUES (?,?,?)";
                PreparedStatement ps1 = (PreparedStatement) connect.getConnection().prepareStatement(insertquery);
                ps1.setString(1, des);
                ps1.setString(2, "" + LocalDate.now());
                ps1.setString(3, Integer.toString(cust_id));
                ps1.executeUpdate();
             

            } catch (Exception e) {
                System.out.print(e);
            }
        }
        else{
        
          JOptionPane.showMessageDialog(null, "Status not Pending or invalid id");
        }

    }
}
