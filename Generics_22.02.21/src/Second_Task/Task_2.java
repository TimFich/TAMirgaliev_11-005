package Second_Task;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a bound of array: ");
        int n = in.nextInt();

        int[] a = new int[n];

        for (int i : new Range(a.length, 0)) {
            System.out.println("Enter a " + (i) + " element of array: ");
            a[i] = in.nextInt();
        }
        System.out.println("From which count you need to start writing");
        int start = in.nextInt();
        if (start < a.length) {
            for (int i : new RangeInterval(a.length, start)) {
                System.out.println(a[i]);
            }
        } else {
            System.out.println("Ты ДЕБИЛ , try again!!!");
        }
    }
}
