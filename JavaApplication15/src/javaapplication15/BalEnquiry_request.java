/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

/**
 *
 * @author 20106
 */
public class BalEnquiry_request {
    
    public int Enquiry(){
      customer my_cus= customer.get_instance();
      return my_cus.getAccount().getBalance();
    }
}
