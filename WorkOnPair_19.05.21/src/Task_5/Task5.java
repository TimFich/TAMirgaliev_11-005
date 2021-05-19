package Task_5;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.next();
        }
        Stream<String> integerStream = Arrays.stream(array);
        integerStream.filter(x -> x.length() == k)
                .filter(x -> x.endsWith("0")|| x.endsWith("1")||x.endsWith("2")||x.endsWith("3")||x.endsWith("4")||x.endsWith("5")||x.endsWith("6")||x.endsWith("7")||x.endsWith("8")||x.endsWith("9"))
                .sorted((a,b) -> String.CASE_INSENSITIVE_ORDER.compare(a,b))
                .forEach(System.out::println);
    }
}
