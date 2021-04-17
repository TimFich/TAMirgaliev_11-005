public class Order {
    String nameOfProduct;
    int count;

    public Order(String nameOfProduct, int count) {
        this.nameOfProduct = nameOfProduct;
        this.count = count;
    }

    @Override
    public String toString() {
        return nameOfProduct + " - " + count;
    }
}
