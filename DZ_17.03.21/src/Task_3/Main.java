package Task_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/timir/IdeaProjects/DZ_17.03.21/src/Task_3/Text_3");
        Scanner in = new Scanner(file);
        String line = in.nextLine();
        Map<String, Integer> mapOfWord = new HashMap<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();
        while (in.hasNext()) {
            line += " " + in.next();
        }
        String[] value = line.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");

        for (int i = 0; i < value.length - 1; i++) {
            if (map.containsKey(value[i])) {
                if (map.get(value[i]).containsKey(value[i + 1])) {
                    mapOfWord = new HashMap<>();
                    mapOfWord.put((String) map.get(value[i]).keySet().toArray()[0], (Integer) map.get(value[i]).values().toArray()[0]);
                    mapOfWord.put(value[i+1], (Integer) (map.get(value[i]).values().toArray()[0]) + 1);
                    map.put(value[i], mapOfWord);
                } else {
                    mapOfWord = new HashMap<>();
                    mapOfWord.put((String) map.get(value[i]).keySet().toArray()[0], (Integer) map.get(value[i]).values().toArray()[0]);
                    mapOfWord.put(value[i + 1], 1);
                    map.put(value[i], mapOfWord);
                }
            } else {
                mapOfWord = new HashMap<>();
                mapOfWord.put(value[i + 1], 1);
                map.put(value[i], mapOfWord);
            }
        }
        System.out.println(map);
    }
}


