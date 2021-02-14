
public class Customer {
    private String name;
    private String password;

    Customer() {

    }


    Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public String toString() {
        return name;
    }

    public String getName() {
        return this.name;
    }
}
