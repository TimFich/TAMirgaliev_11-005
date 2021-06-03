package Task_2;

import java.security.InvalidParameterException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Task2 {
    static char[] symbols = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner in = new Scanner(System.in);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {

                int sizeOfWord = new Random().nextInt(6);
                StringBuilder buf = new StringBuilder();
                for (int i = 0; i < sizeOfWord; i++) {
                    int index = new Random().nextInt(symbols.length);
                    char buf1 = symbols[index];
                    buf.append(buf1);
                }
                System.out.println(Thread.currentThread().getName() + " has added new char to String!");
                return buf.toString();
            }
        };
        System.out.println("Enter a number: ");
        int number = in.nextInt();
        if (number <= 0) {
            throw new InvalidParameterException("Вы ввели неправильное число");
        }
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < number; i++) {
            Future<String> future = scheduledExecutorService.schedule(callable, 1, TimeUnit.SECONDS);
            stringBuilder.append(future.get());
            System.out.println(stringBuilder);
        }
        scheduledExecutorService.shutdown();
    }
}
