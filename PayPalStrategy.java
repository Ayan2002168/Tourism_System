package Payments;

import javax.swing.*;
import java.io.Serializable;

public class PayPalStrategy implements PaymentStrategy, Serializable {
    String emaial;
    String pass;

    public PayPalStrategy(String emaial, String pass) {
        this.emaial = emaial;
        this.pass = pass;
    }


    public void pay(int amount){
        System.out.println("Payment done Successfully with Paypal");
        JOptionPane.showMessageDialog(null,"Payment done Successfully with Paypal");
    }

    @Override
    public String toString() {
        return "PayPal details: \n"+
                "email: "+emaial
                +"\n pass: "+pass;
    }
}
