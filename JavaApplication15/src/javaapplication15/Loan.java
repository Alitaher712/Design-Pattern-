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
public class Loan {

    customer cus = customer.get_instance();

    private boolean check_loan_exist() {

        Connection con = null;

        PreparedStatement p = null;

        con = connect.getConnection();

        String query = "SELECT * FROM loans where user_id=? and loan_status=?";
        try {
            PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query);
            ps.setString(1, Integer.toString(cus.getUser_id()));
            ps.setString(2, " Pending");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed connection");
        }
        return false;
    }

    public String request(int amount, String loantype) {
        int ids = 0;
        boolean check = false, check2 = false;
        if (!check_loan_exist()){

            try {

                String insertquery = "INSERT INTO loans(amount,user_id,loan_type,loan_status) VALUES (?,?,?,?)";
                PreparedStatement ps1 = (PreparedStatement) connect.getConnection().prepareStatement(insertquery);
                ps1.setString(1, Integer.toString(amount));
                ps1.setString(2, Integer.toString(cus.getUser_id()));
                ps1.setString(3, loantype);
                ps1.setString(4, " Pending");
                ps1.executeUpdate();
               
                check = true;
            } catch (Exception e) {
                System.out.print(e);
            }

         
            try {
                String query = "SELECT loan_id FROM loans where user_id=?";
                try {
                    PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query);
                    ps.setString(1, Integer.toString(cus.getUser_id()));
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        ids= rs.getInt("loan_id");
                    }
                    cus.getAccount().getloan().setLoad_id(ids);
                   

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed connection");
                }
                check2 = true;
            } catch (Exception e) {
                System.out.print(e);
            }

            if (check == true && check2 == true) {
                return "Loan Request sent successfully";
            }

            return "Transaction Failed";
        }

        return "There is a loan existed";

    }
}
