package external.tracking;

public class GstTracker {

    public int getGSTPercentage(int itemPrice) {
        if (itemPrice < 1000) {
            return 10;
        } else {
            return 20;
        }
    }
}
