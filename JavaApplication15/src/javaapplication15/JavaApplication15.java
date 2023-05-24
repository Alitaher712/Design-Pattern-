/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication15;

/**
 *
 * @author 20106
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       connect c=new connect();
       c.getConnection();
       
        factory f= new factory();
        account acc= f.get_type("certificate");
        acc.setBalance(1000);
        acc.cost(2000);
        System.out.println(acc.getBalance());
        //System.out.println(acc.cost(200));
        
    }
    
}
