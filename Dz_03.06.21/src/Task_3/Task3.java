package Task_3;

import java.util.Scanner;
import java.util.concurrent.*;

import static java.lang.StrictMath.sqrt;

public class Task3 {

    static class ThreadRun implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is");
            for (int p = x; p <= y; p++) {
                boolean prime = true;
                for (int i = 2; i <= sqrt(p); i++)
                    if (p % i == 0) prime = false;
                if (prime)
                    System.out.println(p);
            }
        }

        int x;
        int y;

        ThreadRun(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        ExecutorService service = Executors.newFixedThreadPool(4);

        int number = sc.nextInt();

        int p = 0;
        int leftBound = 1;
        while (p != number) {
            if (p + 10 > number) {
                p = number;
            } else {
                p = leftBound + 9;
            }
            service.submit(new ThreadRun(leftBound, p));
            leftBound += 10;
            Thread.sleep(1000);

        }

        service.shutdown();


    }


}