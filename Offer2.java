package Packages;

import Services.*;

public class Offer2 extends PackageBuilder{


    @Override
    public void buildTransportation() {
        p.setT(new Bus());
    }

    @Override
    public void buildAccomodation() {
        p.setA(new Hotel());
    }

    @Override
    public void buildActivities() {
        p.setAct(new SeaCruise());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
