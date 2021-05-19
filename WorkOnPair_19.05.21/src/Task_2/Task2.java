package Task_2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer [] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        Stream<Integer> integerStream = Arrays.stream(array);
        System.out.println(integerStream.filter(x -> x > 0)
                .reduce(0,Integer::sum));
    }
}
