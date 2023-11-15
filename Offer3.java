package Packages;

import Services.*;

public class Offer3 extends PackageBuilder{
    @Override
    public void buildTransportation() {
        p.setT(new Bus());
    }

    @Override
    public void buildAccomodation() {
        p.setA(new Motel());
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
