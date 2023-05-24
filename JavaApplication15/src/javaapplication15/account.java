/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

/**
 *
 * @author 20106
 */
public abstract class account {
    int balance;
    String acc_type;
    Loan_2 loan;
    public abstract void setBalance(int balance);
    public abstract int getBalance();
    public abstract void setloan();
    public abstract Loan_2 getloan();
    public abstract void setacc_type(String acc);
    public abstract String getacc_type();
    public abstract void cost(int withdraw_amount);
    public abstract boolean check(int withdraw_amount);
   
}
