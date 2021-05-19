package Task_4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        Stream<Integer> integerStream = Arrays.stream(array);
        integerStream.filter(x -> x / 100 == 0 )
                .filter(x -> x/10 != 0)
                .sorted((a,b) -> Integer.compare(a,b))
                .forEach(System.out::println);
    }
}
