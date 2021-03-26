import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

class Console {
    public void writeFile(ArrayList<Order> order) {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter(".\\text.txt");
            gson.toJson(order, fileWriter);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Order> readFile() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Order>>() {
        }.getType();
        ArrayList<Order> orders = null;
        try {
            FileReader fileReader = new FileReader("./text.txt");
            orders = gson.fromJson(fileReader, type);
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void addToArray(ArrayList<Order> orders) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many product you want to add :");
        int length = in.nextInt();
        for (int i = 0; i < length; i++) {
            System.out.println("Enter name and count of product: ");
            orders.add(new Order(in.next(), in.nextInt()));
        }
    }

    public int removeFromArray(ArrayList<Order> orders) {
        Scanner in = new Scanner(System.in);
        int key = 0;
        System.out.println("name of remove product: ");
        String nameOfRemoveProduct = in.next();
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).equals(nameOfRemoveProduct)) {
                key = i;
            }
        }
        return key;
    }

    public void writeArrayToConsole(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).toString());
        }
    }

    public int changeCountOfProduct(ArrayList<Order> orders , String nameOfChangeProduct) {
        int key = 0;
        System.out.println("name of change product and new count: ");
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).equals(nameOfChangeProduct)) {
                key = i;
            }
        }
        return key;
    }
}

