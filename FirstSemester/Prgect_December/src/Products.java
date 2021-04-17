import java.util.ArrayList;

public class Products {
    private String name;
    private int cost;
    static ArrayList<Products> products = new ArrayList<>();

    public Products(String name, int cost) {
        this.name = name;
        this.cost = cost;
        products.add(this);
    }

    public String toString() {
        return name + " cost " + cost;
    }

    public int getCost() {
        return cost;
    }
}
