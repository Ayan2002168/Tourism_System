package Payments;

import java.io.Serializable;

public interface PaymentStrategy extends Serializable {
     void pay(int amount);

}
