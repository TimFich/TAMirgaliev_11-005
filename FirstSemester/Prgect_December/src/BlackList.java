import java.util.ArrayList;

public class BlackList {
    public BlackList() {

    }

    ArrayList<String> blacklisted = new ArrayList<>();

    public void blocked(String name) {
        blacklisted.add(name);
    }

    public void checkBlacklisted(String name) {
        for (int i = 0; i < blacklisted.size(); i++) {
            if (blacklisted.get(i).equals(name)) {
                System.out.println("Go fuck your self");
            }
        }
    }
}
