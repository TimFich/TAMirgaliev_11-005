import java.util.ArrayList;

public class Buyer {
    String nameOfBuyer;
    ArrayList<City> cities = new ArrayList<>();

    public Buyer(String nameOfBuyer, City city) {
        this.nameOfBuyer = nameOfBuyer;
        cities.add(city);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "nameOfBuyer='" + nameOfBuyer + '\'' +
                ", cities=" + cities +
                '}';
    }
}
