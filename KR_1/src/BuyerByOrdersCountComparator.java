import java.util.Comparator;

public class BuyerByOrdersCountComparator implements Comparator<Buyer> {
    @Override
    public int compare(Buyer o1, Buyer o2) {
        int fistCount = 0;
        int secondCount = 0;
        for (int i = 0; i < o1.cities.size(); i++) {
            for (int j = 0; j < o1.cities.get(i).orders.size(); j++) {
                fistCount += o1.cities.get(i).orders.get(j).count;
            }
        }
        for (int i = 0; i < o2.cities.size(); i++) {
            for (int j = 0; j < o2.cities.get(i).orders.size(); j++) {
                secondCount += o2.cities.get(i).orders.get(j).count;
            }
        }
        return Integer.compare(fistCount,secondCount);
    }
}
