package Packages;

public abstract class PackageBuilder {
    Package p;
    public void createPackage(){
        p=new Package();
        buildTransportation();
        buildAccomodation();
        buildActivities();
    }
    public abstract void buildTransportation();
    public abstract void buildAccomodation();
    public abstract void buildActivities();

    public Package getP() {
        return p;
    }

    public void setP(Package p) {
        this.p = p;
    }
}
