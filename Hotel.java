package Services;

public class Hotel extends Accommodation{
    @Override
    public int getPrice() {
        return 150;
    }

    @Override
    public String toString() {
        return "5 Stars Hotel";
    }
}
