import Payments.PaymentStrategy;
import Services.Service;

import java.io.IOException;
import java.util.ArrayList;

public class Originator {
    Customer c;
    ArrayList<Service>serviceArrayList;
    CareTaker careTaker;
    PaymentStrategy paymentStrategy;

    public Originator(Customer c, ArrayList<Service> serviceArrayList, CareTaker careTaker, PaymentStrategy paymentStrategy) {
        this.c = c;
        this.serviceArrayList = serviceArrayList;
        this.careTaker = careTaker;
        this.paymentStrategy = paymentStrategy;
    }

    public void createReservation(String phoneNumber) throws IOException {
        careTaker.saveMemento(phoneNumber,new Reservation(c,serviceArrayList,paymentStrategy));
    }
}
