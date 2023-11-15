package Payments;

import javax.swing.*;
import java.io.Serializable;
import java.io.StringReader;

public class CreditCardStrategy implements PaymentStrategy, Serializable {
    String name;
    String cardNumber;
    String cvv;
    String dateOfExpiry;

    public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Payment done Successfully with CreditCard");
        JOptionPane.showMessageDialog(null,"Payment done Successfully with CreditCard");
    }

    @Override
    public String toString() {
        return "Credit Card Details \n"+
                name + cardNumber + cvv + dateOfExpiry;
    }
}
