package Third_Task;

import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("До когого числа Фибоначи определить массив : ");
        int n = in.nextInt();
        int[] fib = new int[n];
        enterFib(fib);
        System.out.println("До какого числа вывести числа Фибоначи : ");
        int t = in.nextInt();
        for (int i : new FibonacciRange(t)) {
            System.out.println(fib[i]);
        }
    }

    public static void enterFib(int[] fib) {
        for (int i = 0; i < fib.length; i++) {
            fib[i] = fibonacci(i);
        }

    }

    public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}