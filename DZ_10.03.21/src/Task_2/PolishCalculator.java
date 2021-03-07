package Task_2;

import java.util.Scanner;
import java.util.Stack;

public class PolishCalculator {

    static boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strings = string.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if (tryParseInt(strings[i])) {
                stack.push(Integer.parseInt(strings[i]));
            } else {
                if (stack.size() >= 2) {
                    int b = stack.pop();
                    int a = stack.pop();
                    if (strings[i].equals("+")) stack.push((a + b));
                    if (strings[i].equals("-")) stack.push((a - b));
                    if (strings[i].equals("*")) stack.push((a * b));
                    if (strings[i].equals("/")) stack.push((a / b));
                } else System.out.println("Incorrect enter");
            }
        }
        if (stack.size() == 0 || stack.size() > 1) System.out.println("false");
        else System.out.println(stack.pop());
    }
}
