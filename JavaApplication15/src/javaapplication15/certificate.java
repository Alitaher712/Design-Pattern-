/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import javax.swing.JOptionPane;

/**
 *
 * @author 20106
 */
public class certificate extends account{
    
    
    private static account ac;

  
    private certificate(){}
    
  public static account get_instance(){
    if(ac==null){
        ac=new certificate();
    }
    return ac;
      
  }
     @Override
    public void setBalance(int balance) {
      this.balance=balance;
    }

    @Override
    public int getBalance() {
       return this.balance;
    }
    
    @Override
    public void cost(int withdraw_amount) {
        if(check(withdraw_amount)){
         float c= 1.5f;
         balance -=(c+withdraw_amount);
        }
        else {
           JOptionPane.showMessageDialog(null, "There is not enough balance");
        }
       
    }

    @Override
    public boolean check(int withdraw_amount) {
       if(balance<withdraw_amount+1.5f){
          return false;
       }
       return true;
    }

    @Override
    public void setacc_type(String acc) {
      this.acc_type=acc;
    }

    @Override
    public String getacc_type() {
      return this.acc_type;
    }

    @Override
    public void setloan() {
      this.loan = Loan_2.getinstance();
    }

    @Override
    public Loan_2 getloan() {
       return loan;
    }
}
