
public class Order {
    private Customer customer;
    private Products product;

    public Order(Customer customer, Products product) {
        this.customer = customer;
        this.product = product;
    }

    public String toString() {
        return "Customer: " + customer + "\n" + "Product: " + product;
    }

}
