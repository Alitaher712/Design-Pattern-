/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import javaapplication15.account;
import javax.swing.JOptionPane;

/**
 *
 * @author 20106
 */
public class checking extends account {

    
    private static account ac;
     

   
    private checking(){}
    
  public static account get_instance(){
    if(ac==null){
        ac=new checking();
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
               balance-=withdraw_amount;
         }
         else{
              JOptionPane.showMessageDialog(null, "There is not enough balance");
         }
        
    }
    @Override
    public boolean check(int withdraw_amount) {
        
       if(balance<withdraw_amount){
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
