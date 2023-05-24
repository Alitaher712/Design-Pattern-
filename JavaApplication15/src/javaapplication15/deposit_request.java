/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author 20106
 */
public class deposit_request {
    
    customer cus=customer.get_instance();
    public void deposit(int amount){
    int current_balance= cus.getAccount().getBalance();
    cus.getAccount().setBalance(current_balance+amount);
  
    Connection con = null;

        PreparedStatement p = null;

        con = connect.getConnection();

        try {

           String sql = "UPDATE accounts SET balance = "+cus.getAccount().getBalance()+" WHERE user_id = "+cus.getUser_id();

            p = con.prepareStatement(sql);

            p.execute();

        }

        catch (SQLException e) {

            System.out.println(e);

        }
 
    }
}
