import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/timir/IdeaProjects/WorkForLesson/src/text");
        Scanner in = new Scanner(file);
        HashMap<String, HashMap<String, HashMap<String, Integer>>> mapOfAll = new HashMap<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] text = line.split("\\|");

            if (mapOfAll.containsKey(text[0])) {
                HashMap<String, HashMap<String, Integer>> mapHashMap = mapOfAll.get(text[0]);
                if (mapHashMap.containsKey(text[1])) {
                    HashMap<String, Integer> mapOfProduct1 = mapHashMap.get(text[1]);
                    if (mapOfProduct1.containsKey(text[2])) {
                        mapOfProduct1.put(text[2], mapOfProduct1.get(text[2]) + Integer.parseInt(text[3]));
                        continue;
                    }
                    mapOfAll.get(text[0]).get(text[1]).put(text[2], Integer.parseInt(text[3]));

                    continue;
                }
                HashMap<String, Integer> mapOfProduct = new HashMap<>();
                mapOfProduct.put(text[2], Integer.parseInt(text[3]));
                mapHashMap.put(text[1], mapOfProduct);
                mapOfAll.put(text[0], mapHashMap);


                continue;
            }
            HashMap<String, HashMap<String, Integer>> mapOfCity = new HashMap<>();
            HashMap<String, Integer> mapOfProduct = new HashMap<>();
            mapOfProduct.put(text[2], Integer.parseInt(text[3]));
            mapOfCity.put(text[1], mapOfProduct);
            mapOfAll.put(text[0], mapOfCity);
        }
        for (String customer : mapOfAll.keySet()) {
            System.out.println("///////////");
            System.out.println(customer + ":");
            int counter = 0;
            for (String city : mapOfAll.get(customer).keySet()) {
                if (counter != 0)
                    System.out.println("///////////");
                System.out.println("\t\t" + city + ":");
                for (String order : mapOfAll.get(customer).get(city).keySet()) {
                    System.out.println("\t" + order + ":\t" + mapOfAll.get(customer).get(city).get(order));
                }
                counter++;
            }
        }
    }

}
