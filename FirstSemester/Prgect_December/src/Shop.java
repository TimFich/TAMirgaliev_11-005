import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    BlackList blackList = new BlackList();
    private Scanner in = new Scanner(System.in);
    private ArrayList<Customer> customers = new ArrayList<>();
    Customer customer = new Customer();

    public ArrayList<Order> list = new ArrayList<>();


    public void addProducts(Order order) {
        list.add(order);
    }

    public void purchase(Customer customer, Products product) {
        Order order1 = new Order(customer, product);
        addProducts(order1);
    }

    public void checkHow() {
        boolean exit1 = true;
        while (exit1) {
            System.out.println("If you are an administrator press [button 1]\t"
                    + "if you are a customer press [button 2]\t"
                    + "if you want to exit from shop press [button 3]: ");
            char key = in.next().charAt(0);
            switch (key) {
                case '1':
                    checkAdmin();

                    break;
                case '2':
                    menuCustomer();
                    break;
                case '3':
                    exit1 = false;
                    break;
            }
        }
    }


    public void checkAdmin() {

        System.out.println("Enter an admin  password:");
        boolean exitAdmin = true;
        while (exitAdmin) {
            int password = in.nextInt();
            if (password == 1234) {
                menuAdmin();
                break;
            } else {
                System.out.println("Uncorrected password , enter a password again :");
            }

        }

    }


    public void menuAdmin() {
        System.out.println("If you want to add products press [button 1]\t" + "if you want see a list of customers press [button 2]\t"
                + "If you want to see a black list press [button 3]\t" +
                "If you want to exit from admin menu press [button 4]:");
        char key = in.next().charAt(0);
        switch (key) {
            case '1':
                int exit2 = 1;
                while (exit2 == 1) {
                    System.out.println("Add a new products: ");
                    System.out.println("Enter a name of product and cost of it :");
                    Products product = new Products(in.next(), in.nextInt());
                    System.out.println("If you want to add a new product press [button 1]\t" + " If you want to exit press [button 0]");
                    exit2 = in.nextInt();
                    if (exit2 == 0) {
                        break;
                    }
                }
                break;
            case '2':
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                break;
            case '3':
                blackList = new BlackList();
                System.out.println(blackList.blacklisted.size());
                for (int i = 0; i < blackList.blacklisted.size(); i++) {
                    System.out.println(i + blackList.blacklisted.get(i));
                }
                break;
            case '4':
                checkHow();
                System.exit(0);
                break;

        }
    }

    private Customer createNewCustomer() {
        System.out.println("Enter your login :");
        String name = in.next();
        System.out.println("Enter your password:");
        String password = in.next();
        return new Customer(name, password);
    }

    public void menuCustomer() {
        System.out.println("Welcome to internet shop!!!");
        customer = createNewCustomer();
        blackList.checkBlacklisted(customer.getName());
        customers.add(customer);

        boolean exit = true;
        while (exit) {
            System.out.println("If you want to see a list of products press [button 1]\t " +
                    "if you want to buy a products press [button 2]\t " +
                    "if you want to exit from this shit press [button 3] ");
            char key1 = in.next().charAt(0);
            switch (key1) {
                case '1':
                    for (int i = 0; i < Products.products.size(); i++) {
                        System.out.println((i + 1) + " " + Products.products.get(i));
                    }
                    break;
                case '2':
                    int a = 0;
                    boolean exit3 = true;
                    while (exit3) {
                        System.out.println("Enter a number of product: ");
                        int number = in.nextInt();
                        purchase(customer, Products.products.get(number - 1));
                        System.out.println("Do you want to continue shopping press [button 1] \t"
                                + "If you want go to cart press [button 0]\t ");
                        a = in.nextInt();
                        if (a == 0) {
                            exit3 = false;
                            payment();
                        } else {
                            if (a != 1) {
                                System.out.println("You press a wrong button!!!");
                            }
                        }

                    }
                    break;
                case '3':
                    exit = false;
                    break;
            }
        }
    }

    public void payment() {
        System.out.println("How do you want to pay for the product:\n" + "1.Cash : press [button 1]\n" + "2.Card : press [button 2]");
        char key = in.next().charAt(0);
        Shop shop = new Shop();
        switch (key) {
            case '1':
                System.out.println("You can pay for your order at the pick-up point");
                checkHow();
                break;
            case '2':
                System.out.println("Enter your card number (without spaces!!!)");
                String cardNumber = in.next();
                if (cardNumber.length() != 16) {
                    System.out.println("Sorry , you should be blacklisted ;)");
                    System.out.println(customer.getName());
                    blackList.blacklisted.add(customer.getName());
                    shop.checkHow();
                } else {
                    System.out.println("Enter CVV or CVC cod");
                    String cvv = in.next();
                    if (cvv.length() != 3) {
                        System.out.println("Sorry , you should be blacklisted ;)");
                        blackList.blacklisted.add(customer.getName());
                        shop.checkHow();

                    } else {
                        System.out.println("Thanks for your order :)  It will wait you at the pick-up point");
                    }

                }
                break;
        }

    }
}