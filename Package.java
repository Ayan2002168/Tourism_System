package Packages;

import Services.Accommodation;
import Services.Activities;
import Services.Transportation;

public class Package {
    Transportation t;
    Accommodation a;
    Activities act;

    public Transportation getT() {
        return t;
    }

    public void setT(Transportation t) {
        this.t = t;
    }

    public Accommodation getA() {
        return a;
    }

    public void setA(Accommodation a) {
        this.a = a;
    }

    public Activities getAct() {
        return act;
    }

    public void setAct(Activities act) {
        this.act = act;
    }

    public int getTotalPrice(){
        int totalPrice=t.getPrice()+a.getPrice()+ act.getPrice();
        return totalPrice;
    }
}
