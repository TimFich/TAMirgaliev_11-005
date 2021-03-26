import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        new FileWriter(".\\text.txt", false).close();
        ArrayList<Order> orders = new ArrayList<>();
        Console console = new Console();
        boolean flag = true;
        while (flag) {
            writeConsole();
            System.out.println("Enter what do you want : ");
            char key = in.next().charAt(0);
            switch (key) {

                case '1': {
                    console.writeFile(orders);
                    break;
                }
                case '2': {
                    console.readFile();
                    break;
                }
                case '3': {
                    console.addToArray(orders);
                    break;
                }
                case '4': {
                    orders.remove(console.removeFromArray(orders));

                    break;
                }
                case '5': {
                    System.out.println("Enter a name of change product and count of it: ");
                    String name = in.next();
                    int count = in.nextInt();
                    orders.get(console.changeCountOfProduct(orders, name)).count = count;
                    break;
                }
                case '6': {
                    console.writeArrayToConsole(orders);
                    break;
                }
                case '7': {
                    flag = false;
                    break;
                }
            }
        }

    }

    public static void writeConsole() {
        System.out.println("""
                [1] Write File\s
                [2] Read File\s
                [3] Add to Array new products
                [4] Remove product\s
                [5] Change count of product
                [6] Write product to console
                [7] Exit""");
    }

}