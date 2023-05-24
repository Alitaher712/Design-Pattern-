/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

/**
 *
 * @author 20106
 */
public class Transaction_facade {
    private TransactionsDetails ah;
    private deposit_request dr;
    private withdraw_request wr;
    private transfer_request tr;
    private BalEnquiry_request be;
    private Loan loan;
    
    
    public void deposit(int amount){
     
         dr =new deposit_request();
         dr.deposit(amount);
        
    }
     
     public String[][] acchistory(){
         ah=new TransactionsDetails();
        return ah.display();
         
     }

  public void withdraw(int amount){
    wr=new withdraw_request();
    wr.withdraaw(amount);
  }
    
   public void transfer(int id , int amount){
       tr=new transfer_request();
       tr.transfer(id, amount);
   }
   public String loan (int amount, String loantype){
     loan=new Loan();
    return loan.request(amount, loantype);
   }
   
   public int balanceenquiry(){
    be=new BalEnquiry_request();
    return be.Enquiry();
   }
    
}
