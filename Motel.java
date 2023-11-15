package Services;

public class Motel extends Accommodation{
    @Override
    public int getPrice() {
        return 80;
    }

    @Override
    public String toString() {
        return "4 Stars Motel";
    }
}
