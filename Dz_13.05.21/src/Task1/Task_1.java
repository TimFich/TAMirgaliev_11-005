package Task1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a length of array: ");
        int n = in.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.next();
        }
        Stream<String> stringStream = Arrays.stream(array)
                .filter(x -> x.startsWith("a"))
                .sorted((a, b) -> Integer.compare(a.length(), b.length()));
        stringStream.forEach(System.out::println);
    }
}
