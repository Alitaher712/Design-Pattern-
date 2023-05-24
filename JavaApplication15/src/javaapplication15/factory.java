/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

import javaapplication15.account;

/**
 *
 * @author 20106
 */
public class factory {
    public account get_type(String name){
       
         if (name.equalsIgnoreCase("Checking Account")) {
         //   System.out.println("1");
             return checking.get_instance();
             
        }
         else if (name.equalsIgnoreCase("Saving Account")) {
             // System.out.println("2");
              return saving.get_instance();
        }
         else if (name.equalsIgnoreCase("MoneyMarket Account")) {
            //  System.out.println("3");
              return moneymarket.get_instance();
        }
         
         else if (name.equalsIgnoreCase("Certificate Deposit")) {
            //  System.out.println("4");
              return certificate.get_instance();
        }
        // System.out.println("ssssssssssssssssssssssss");
        return null;
    }
}
