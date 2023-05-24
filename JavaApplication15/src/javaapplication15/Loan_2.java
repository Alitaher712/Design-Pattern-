/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication15;

/**
 *
 * @author 20106
 */
public class Loan_2  {
    int load_id;
    int amount;
    String loan_type;
    String loan_status;
    private static Loan_2 instance;
    private Loan_2() {
    }
    public static Loan_2 getinstance() {
        if (instance == null) {
            instance = new Loan_2();
        }
        return instance;
    }
    public int getLoad_id() {
        return load_id;
    }

    public void setLoad_id(int load_id) {
        this.load_id = load_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public String getLoan_status() {
        return loan_status;
    }

    public void setLoan_status(String loan_status) {
        this.loan_status = loan_status;
    }
}
