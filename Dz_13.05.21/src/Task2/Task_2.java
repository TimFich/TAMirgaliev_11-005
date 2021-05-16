package Task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a length of array: ");
        int n = in.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        Stream<Integer> integerStream = Arrays.stream(array);
        integerStream
                .sorted((a, b) -> Integer.compare(a % 10, b % 10))
                .map(x -> x / 10)
                .distinct()
                .forEach(System.out::println);
    }
}
