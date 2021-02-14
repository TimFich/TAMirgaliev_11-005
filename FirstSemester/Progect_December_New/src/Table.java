import java.util.ArrayList;

public class Table {
    private int number;
    private boolean status;
    private Customer customer;
    private ArrayList<Dish> dishes;
    private int account;
    private boolean checkExit;
    private int timer;

    Table() {
    }

    public Table(int number, boolean status, Customer customer, ArrayList<Dish> dishes, int account, boolean checkExit, int timer) {
        this.number = number;
        this.status = status;
        this.customer = customer;
        this.dishes = dishes;
        this.account = account;
        this.timer = timer;
        this.checkExit = checkExit;
    }

    public int getNumber() {
        return number;
    }

    public boolean isStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAccount() {
        return account;
    }

    public boolean isCheckExit() {
        return checkExit;
    }

    public void setCheckExit(boolean checkExit) {
        this.checkExit = checkExit;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    String getListOfDishes(Table table) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < table.getDishes().size(); i++) {
            str.append(table.getDishes().get(i).getName());
            if (table.getDishes().get(i).getTimer() > 0) {
                str.append("(").append(table.getDishes().get(i).getTimer()).append(")");
            } else {
                str.append("(Issued)");
            }
            if (i != table.getDishes().size() - 1) {
                str.append(", ");
            }
        }
        return str.toString();
    }


    String getExitTimer(Table table) {
        String str = "";
        if (table.checkExit) {
            str += "It's time to pay the bill : " + table.getTimer() / 60 + " min " + table.getTimer() % 60 + " sec\n";
        }
        return str;
    }

    void tableToString(Table table) {
        if (!table.isStatus()) {
            System.out.println("Number of Table : " + table.getNumber());
            System.out.println("Name of customer : " + table.getCustomer().getName());
            System.out.println("Age of customer : " + table.getCustomer().getAge());
            System.out.println("Dishes: " + getListOfDishes(table));
            System.out.println("Bil: " + table.getAccount());
            System.out.print(getExitTimer(table));
            System.out.println("---------");
        }
    }
}
