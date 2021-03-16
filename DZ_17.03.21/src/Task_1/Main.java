package Task_1;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        try {
            File file = new File("/Users/timir/IdeaProjects/DZ_17.03.21/src/Task_1/text.txt");
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            while (sc.hasNext()) {
                line += " " + sc.next();
            }
            String[] value = line.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");

            for (int i = 0; i < value.length; i++) {
                if (map.containsKey(value[i])) {
                    map.put(value[i], map.get(value[i]) + 1);
                } else {
                    map.put(value[i], 1);
                }
            }
            System.out.println(map);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
