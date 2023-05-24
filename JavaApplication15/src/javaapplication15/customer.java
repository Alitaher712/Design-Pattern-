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
public class customer extends users{

    
   private String SSN ;
   private String username;
   private String gender;
   private int age;
   private account account;
   private static customer intance;
   private customer(){}
    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public account getAccount() {
        return account;
    }

    public void setAccount(account account) {
        this.account = account;
    }
    public static customer get_instance(){
     if(intance==null){
     intance=new customer();
     }
     return intance;
    }
    @Override
    public boolean login(int id ,String pass) {
      
        String query = "SELECT user_id,password FROM `users` WHERE `user_id` =? and `password` =?";
        try {
            PreparedStatement ps = (PreparedStatement)connect.getConnection().prepareStatement(query);
            
              ps.setString(1, Integer.toString(id));
              ps.setString(2, pass);
              
              ResultSet rs = ps.executeQuery();
              if(rs.next()){
               
                  return true;
                  
              }
              else{
                    return false;
              }
        } 
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Failed connection");
        }
        
        return false;
    }
    
    
      private boolean checkpass(char[] pass, char[] con_pass) {
        if (pass.length != con_pass.length) {
            return false;
        }
        for (int i = 0; i < pass.length; i++) {

            if (pass[i] != con_pass[i]) {
                return false;
            }
        }
        return true;
    }
     
     
    public boolean validation(String user_name, char[] pass,  char[] con_pass , String ssn, String gender,  String acctype ,int age_value){
     //boolean valid =true;
     
     
     int upChars = 0, lowChars = 0;
        int special = 0, digits = 0, count = 0;
      
        char ch;
        int total = pass.length;
        if (user_name.length() == 0 || pass.length == 0 || con_pass.length == 0 || ssn.length() == 0) {
           JOptionPane.showMessageDialog(null, "please fill missing data");
            
           return false;
          
        }

        if (total < 8) {
            JOptionPane.showMessageDialog(null, "passwords must be more than 8 characters");
           
            return false;
        } else {
            for (int i = 0; i < total; i++) {
                ch = pass[i];
                if (Character.isUpperCase(ch)) {
                    upChars = 1;
                } else if (Character.isLowerCase(ch)) {
                    lowChars = 1;
                } else if (Character.isDigit(ch)) {
                    digits = 1;
                } else {
                    special = 1;
                }
            }
        }
        if (upChars != 1 || lowChars != 1 || digits != 1 || special != 1) {
            JOptionPane.showMessageDialog(null, "Weak password !! must contain uppercase,lowercase,special characters and a digit");
           return false;
        }
        if (!checkpass(pass, con_pass)) {
            JOptionPane.showMessageDialog(null, "Password doesn't match");
          return false;
        }

        for (int j = 0; j < ssn.length(); j++) {

            if (ssn.charAt(j) >= '0' && ssn.charAt(j) >= '9') {
                count++;
            }
        }
        if (ssn.length() != 14 && count != 14) {
            JOptionPane.showMessageDialog(null, "SSN must be of length 14 and numeric");
           return false;
        }
       // unique SSN
        String query = "SELECT SSN FROM users where SSN=? ";

        try {

            PreparedStatement ps = (PreparedStatement) connect.getConnection().prepareStatement(query);
            ps.setString(1, ssn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "SSN is used");
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed connection");
        }

        if (gender.equalsIgnoreCase("notselected")) {
           JOptionPane.showMessageDialog(null, "Please choose your gender");
           return false;
        }
       
        if (age_value < 18) {
            JOptionPane.showMessageDialog(null, "Your age must be more than 18");
           return false;
        }
       
       return true;
    }
    
}
