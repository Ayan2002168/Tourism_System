package Services;

public class Taxi extends Transportation{
    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public String toString() {
        return "Uber Taxi";
    }
}
