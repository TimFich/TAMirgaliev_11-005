import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
        String line = reader.readLine();

        while (line != null) {
            String[] text1 = line.split("\\|");
            addToArray(text1);
            line = reader.readLine();
        }
        printAll(buyers);
        BuyerByCityCountComparator buyerByCityCountComparator = new BuyerByCityCountComparator();
        BuyerByNameComparator buyerByNameComparator = new BuyerByNameComparator();
        BuyerByOrdersCountComparator buyerByOrdersCountComparator = new BuyerByOrdersCountComparator();

        TreeSet<Buyer> sortedByName = new TreeSet<>(buyerByNameComparator.thenComparing(buyerByCityCountComparator.thenComparing(buyerByOrdersCountComparator)));
        TreeSet<Buyer> sortedByOrders = new TreeSet<>(buyerByOrdersCountComparator.thenComparing(buyerByCityCountComparator.thenComparing(buyerByNameComparator)));
        sortedByName.addAll(buyers);
        sortedByOrders.addAll(buyers);
        writeFile(sortedByName , "output1.txt");
        writeFile(sortedByOrders ,"output2.txt");

    }

    static void addToArray(String[] str) {
        String buyerName = str[0];
        String cityName = str[1];
        String orderName = str[2];
        int count = Integer.parseInt(str[3]);

        Order order = new Order(orderName, count);
        City city = new City(cityName, order);
        Buyer buyer = new Buyer(buyerName, city);

        if (buyers.size() == 0) {
            buyers.add(buyer);
        } else {
            int idBuyer = checkNameBuyer(buyerName);
                if (idBuyer!=-1) {
                    int idCity = checkNameCity(buyers.get(idBuyer).cities, cityName);
                    if (idCity != -1) {
                        int idOrder = checkNameOrder(buyers.get(idBuyer).cities.get(idCity).orders, orderName);
                        if (idOrder != -1) {
                            buyers.get(idBuyer).cities.get(idCity).orders.get(idOrder).count +=count;
                        } else {
                            buyers.get(idBuyer).cities.get(idCity).orders.add(order);
                        }
                    } else {
                        buyers.get(idBuyer).cities.add(city);
                    }
                } else {
                    buyers.add(buyer);
                }

        }
    }

    static int checkNameBuyer(String name) {
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).nameOfBuyer.equals(name)) return i;
        }
        return -1;
    }

    static int checkNameCity(ArrayList<City> cities, String name) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).nameOfCity.equals(name)) return i;
        }
        return -1;
    }



    static void printAll(ArrayList<Buyer> list) {
        Buyer buyer = list.get(0);
            System.out.println(buyer.nameOfBuyer + ":");
            for (City city : buyer.cities) {
                System.out.println("\t" + city.nameOfCity + ":");
                for (Order order : city.orders) {
                    System.out.println("\t\t" + order.toString());
                }
            }
    }

    static int checkNameOrder(ArrayList<Order> orders, String name) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).nameOfProduct.equals(name)) return i;
        }
        return -1;
    }

    public static void writeFile(TreeSet<Buyer> buyers1 , String nameOfFile){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameOfFile))) {
            oos.writeObject(buyers);
        } catch (IOException ignored) {
        }
    }
}