package Task_1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        Stack<Character> stack = new Stack<>();
        char[] symbol1 = new char[]{'{', '(', '['};
        char[] symbol2 = new char[]{'}', ')', ']'};
        boolean flag = true;

        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < symbol1.length; j++) {
                if (string.charAt(i) == symbol1[j]) {
                    stack.push(string.charAt(i));
                }
                if (string.charAt(i) == symbol2[j]) {
                    if (stack.size() != 0 && stack.peek() == symbol1[j]) {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                }
            }
            if (!flag)
                break;
        }
        if (flag)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
