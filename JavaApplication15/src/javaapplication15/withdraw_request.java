/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 20106
 */
public class withdraw_request {
    
    
    customer cus=customer.get_instance();
    public void withdraaw(int amount){
        
        cus.getAccount().cost(amount);
   
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
