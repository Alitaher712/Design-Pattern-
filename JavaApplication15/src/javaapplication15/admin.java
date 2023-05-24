/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

/**
 *
 * @author 20106
 */
public class admin extends users {

    @Override
    public boolean login(int id , String pass) {
        
        if(id==1 && pass.equalsIgnoreCase("admin")){
           return true;
        }
        return false;
    }
    
}
