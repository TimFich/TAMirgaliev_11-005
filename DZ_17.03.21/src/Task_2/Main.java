package Task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/timir/IdeaProjects/DZ_17.03.21/src/Task_2/Text.txt");
        Scanner in = new Scanner(file);
        Map<String, Integer> mapOfProducts = new HashMap<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();
        String line = in.nextLine();

        while (in.hasNext()) {
            line += " " + in.next();
        }

        String[] value = line.replaceAll("\\p{Punct}", "").split(" ");

        for (int i = 0; i < value.length; i = i + 3) {
            mapOfProducts = new HashMap<>();
            if (map.containsKey(value[i])) {
                if (map.get(value[i]).containsKey(value[i + 1])) {
                    mapOfProducts = new HashMap<>();
                    mapOfProducts.put((String) map.get(value[i]).keySet().toArray()[0] ,(Integer) map.get(value[i]).values().toArray()[0]);
                    mapOfProducts.put(value[i+1],(Integer) (map.get(value[i]).values().toArray()[0]) + Integer.parseInt(value[i+2]));
                    map.put(value[i],mapOfProducts);
                } else {
                    mapOfProducts.put((String) map.get(value[i]).keySet().toArray()[0], (Integer) map.get(value[i]).values().toArray()[0]);
                    mapOfProducts.put(value[i + 1], Integer.parseInt(value[i + 2]));
                    map.put(value[i], mapOfProducts);
                }
            } else {
                mapOfProducts.put(value[i + 1], Integer.parseInt(value[i + 2]));
                map.put(value[i], mapOfProducts);
            }
        }
        System.out.println(map);
    }
}

