import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BotCommand {
    ArrayList<Tables> tables1 = new ArrayList<>();
    private int count = 0;

    @SomeAnnotation(names = {"/help", "/command"}, description = "Get command", args = "")
    public String help(String[] args) {
        StringBuilder builder = new StringBuilder("Я умею такие команды:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(SomeAnnotation.class))
                continue;

            SomeAnnotation cmd = m.getAnnotation(SomeAnnotation.class);
            builder.append(Arrays.toString(cmd.names())).append(": ").append(cmd.description()).append(" - ").append(cmd.args()).append("\n");
        }

        return builder.toString();
    }


    @SomeAnnotation(names = {"/hello", "/hi"}, description = "Say hello to bot", args = "")
    public String hello(String[] args) {
        return "Hello World!";
    }

    @SomeAnnotation(names = {"/bye", "/goodBye"}, description = "Say buy to bot", args = "")
    public String buy(String[] args) {
        return "Good Bye";
    }

    @SomeAnnotation(names = "/booktable", description = "Book the table in cafe", args = "")
    public String booking(int cnt, Message message) {
        if (cnt == 0) {
            return "Enter a count of booking place and name of booker:";
        }
        if (cnt == 1) {

            Tables tables = new Tables(Integer.parseInt(message.getText().split(" ")[0]), message.getText().split(" ")[1]);
            tables1.add(tables);

        }

        return "Your order is in the cart";
    }

    @SomeAnnotation(names = "/seeorders", description = "see Array List of orders", args = "")
    public String seeOrders(String[] args) {
        String res = "";
        for (int i = 0; i < tables1.size(); i++) {
            res += (i+1) + ":--- " + tables1.get(i).toString() + " ";
        }
        return res;
    }
    @SomeAnnotation(names = "/cleanlist",description = "Clean a Array list of orders", args = "")
    public String clean(String [] args){
        tables1.clear();
        return "Array list is clear";
    }
    @SomeAnnotation(names = {"/revers", "/rev"}, description = "Revers a word", args = "")
    public String reversWord(String[] args) {
        String res = String.join(" ", args);
        StringBuilder builder = new StringBuilder(res);
        builder.reverse();
        return builder.toString();
        }
    }