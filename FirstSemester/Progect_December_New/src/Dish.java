public class Dish {
    private final String name;
    private int timer;
    private final int cost;
    private boolean status;

    public Dish(String name, int timer, int cost, boolean status) {
        this.name = name;
        this.timer = timer;
        this.cost = cost;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTimer() {
        return timer;
    }

    public int getCost() {
        return cost;
    }

    public boolean isStatus() {
        return !status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
