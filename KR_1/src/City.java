import java.util.ArrayList;

public class City {
    String nameOfCity;
    ArrayList<Order> orders = new ArrayList<>();

    public City(String nameOfCity, Order order) {
        this.nameOfCity = nameOfCity;
        orders.add(order);
    }
}
