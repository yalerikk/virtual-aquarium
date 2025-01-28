import java.util.Comparator;

public class ReserveComparator implements Comparator<Fish> {
    @Override
    public int compare(Fish fish1, Fish fish2) {
        return Integer.compare(fish2.getLengthOfLife(), fish1.getLengthOfLife());
    }
}
