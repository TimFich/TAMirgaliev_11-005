import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Bot {
    ArrayList<Tables> tables1 = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    Main main = new Main();

    ArrayList<Tables> tables = new ArrayList<>();

    @SomeAnnotation(names = {"help", "command"}, description = "Get command", args = "")
    public String help(String[] args) {
        StringBuilder builder = new StringBuilder("Я умею в такие команды:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(SomeAnnotation.class))
                continue;

            SomeAnnotation cmd = m.getAnnotation(SomeAnnotation.class);
            builder.append(Arrays.toString(cmd.names())).append(": ").append(cmd.description()).append(" - ").append(cmd.args()).append("\n");
        }

        return builder.toString();
    }


    @SomeAnnotation(names = {"hello", "hi"}, description = "Say hello to bot", args = "")
    public String hello(String[] args) {
        return "Hello World!";
    }

    @SomeAnnotation(names = {"bye", "good Bye"}, description = "Say buy to bot", args = "")
    public String buy(String[] args) {
        return "Good Buy";
    }

    @SomeAnnotation(names = "booktable", description = "Book the table in cafe", args = "")
    public String booking(String[] args) {
        System.out.println("How many tables do you want to book:");
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            Tables tables = new Tables(in.nextInt(), in.next());
            tables1.add(tables);
        }
        return "Your order is in the cart";
    }

    @SomeAnnotation(names = "seeorders", description = "see Array List of orders", args = "")
    public String seeOrders(String[] args) {
        for (int i = 0; i < tables1.size(); i++) {
            System.out.println(tables1.get(i).toString());
        }
        return "";
    }


    private HashMap<String, Method> commands;

    public Bot() {
        commands = new HashMap<>();

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(SomeAnnotation.class))
                continue;

            SomeAnnotation cmd = m.getAnnotation(SomeAnnotation.class);
            for (String name : cmd.names())
                commands.put(name, m);
        }
    }

    public String processUserInput(String input) {
        if (input.isEmpty())
            return "Я вас не понимаю process input is empty";

        String[] split = input.split(" ");
        String command = split[0].toLowerCase();
        String[] args = Arrays.copyOfRange(split, 1, split.length);

        Method m = commands.get(command);

        if (m == null)
            return "Я вас не понимаю";

        try {
            return (String) m.invoke(this, (Object) args);
        } catch (Exception e) {
            return "Что-то пошло не так, попробуйте ещё раз";
        }
    }
}
