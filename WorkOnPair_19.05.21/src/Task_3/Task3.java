package Task_3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        Stream<Integer> integerStream = Arrays.stream(array);
        List<Integer> list = integerStream.filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(list);
    }
}
