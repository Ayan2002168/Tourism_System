import Payments.PaymentStrategy;
import Services.Service;

import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable {
    Customer c;
    ArrayList<Service> serviceArrayList;

    PaymentStrategy paymentStrategy;

    public Reservation(Customer c, ArrayList<Service> serviceArrayList, PaymentStrategy paymentStrategy) {
        this.c = c;
        this.serviceArrayList = serviceArrayList;
        this.paymentStrategy = paymentStrategy;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public ArrayList<Service> getServiceArrayList() {
        return serviceArrayList;
    }

    public void setServiceArrayList(ArrayList<Service> serviceArrayList) {
        this.serviceArrayList = serviceArrayList;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public String toString() {
        return c.toString() + "\n"+
                serviceArrayList.toString() + "\n" +
                paymentStrategy.toString();
    }
}
