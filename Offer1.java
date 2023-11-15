package Packages;

import Services.*;

public class Offer1 extends PackageBuilder{
//    public Offer1() {
////        super(new Taxi(),new Hotel(),new SkyDiving());
////    }


    @Override
    public void buildTransportation() {
        p.setT(new Taxi());
    }

    @Override
    public void buildAccomodation() {
        p.setA(new Hotel());
    }

    @Override
    public void buildActivities() {
        p.setAct(new SkyDiving());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
