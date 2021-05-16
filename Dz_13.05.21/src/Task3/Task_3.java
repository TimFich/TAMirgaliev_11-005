package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Task_3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\Task3\\text.txt");
        Scanner in = new Scanner(file);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        in.tokens().map(x -> x.split("\\|"))
                .map(x -> stringIntegerHashMap.containsKey(x[0]) ? stringIntegerHashMap.put(x[0], stringIntegerHashMap.get(x[0]) + Integer.parseInt(x[1])) : stringIntegerHashMap.put(x[0], Integer.parseInt(x[1]))).collect(Collectors.toList());

        stringIntegerHashMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }
}
