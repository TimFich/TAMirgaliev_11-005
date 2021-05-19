package Task_1;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a length of array: ");
        int n = in.nextInt();
        String[] arrayOfString = new String[n];
        for (int i = 0; i <arrayOfString.length ; i++) {
            arrayOfString[i] = in.next();
        }
        Stream<String> stringStream = Arrays.stream(arrayOfString);
        System.out.println(stringStream
                .map(x -> x.length())
                .reduce(0,Integer::sum));
    }
}
