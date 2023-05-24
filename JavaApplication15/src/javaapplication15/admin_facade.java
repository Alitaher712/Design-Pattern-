/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

/**
 *
 * @author 20106
 */
public class admin_facade {
    private ShowAccounts sa;
    private ShowTransactions st;
    private RespondLoanRequests al;
    
    
    public String[][] S_Acc(){
     sa=new ShowAccounts();
     return sa.show_acc();
    }
    
     public String[][] S_trans(){
     st=new ShowTransactions();
     return st.S_transactions();
    }
     
     public void respondToRequest(int loan_id,String status){
      al=new RespondLoanRequests();
      al.respond(loan_id,status);
    }
}
