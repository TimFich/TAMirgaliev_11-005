import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        new Main().addTables();
        new Main().timer();
    }

    int timer = 6; // Единица времение
    int tableCount = 3; // Максимальное количество столов
    int maxDishes = 2; // Максимальное заказ блюд
    int outputFrequency = 6; // Частота вывода в консоль
    int randomOfDeleteFromTable = 4; // Шанс ухода посетителя раньше времени от 1 до 7
    int randomOfCreateNewDish = 7; // Шанс добавления нового блюда посетителю от 1 до 7
    int timeOfProgram = 60; // Время работы программы в секундах

    Table table = new Table();

    private final Dish[] dishes = new Dish[]{
            new Dish("Pasta", 50, 30, false),
            new Dish("Borsch", 30, 15, false),
            new Dish("Pickle", 20, 98, false),
            new Dish("Plov", 30, 26, false),
            new Dish("Hot-Dog", 40, 63, false),
            new Dish("Garlic", 20, 28, false),
            new Dish("Hren", 10, 189, false)
    };

    private final String[] names = new String[]{
            "Timur",
            "Kirill",
            "Karina",
            "Ainur",
            "Dmitriu",
            "Ilsur",
            "Maga",
            "Mihail",
            "Vanya",
            "Evgeniy"
    };

    static ArrayList<Table> tables = new ArrayList<>();


    void timer() {
        int date = new Date().getSeconds();
        boolean check = true;
        while (timeOfProgram > 0) {
            if (date % outputFrequency == 0) {
                if (check) {
                    mainMenu();
                    check = false;
                    timeOfProgram -= outputFrequency;
                }

            } else {
                check = true;
            }
            date = new Date().getSeconds();
        }
    }

    private void addCustomerToTable() {
        ArrayList<Dish> newDish = new ArrayList<>();
        String name = names[(int) (Math.random() * names.length)];
        int age = (int) (18 + Math.random() * 35);
        int countOfDishes = (int) (1 + Math.random() * maxDishes);

        Customer newCustomer = new Customer(name, age);

        int account = 0;
        for (int i = 0; i < countOfDishes; i++) {
            newDish.add(dishes[(int) (Math.random() * dishes.length)]);
            account += newDish.get(newDish.size() - 1).getCost();
        }

        for (Table value : tables) {
            if (value.isStatus()) {
                value.setStatus(false);
                value.setCustomer(newCustomer);
                value.setDishes(newDish);
                value.setAccount(account);
                break;
            }
        }

    }

    void deleteCustomerFromTable(Table table) {
        table.setDishes(null);
        table.setStatus(true);
        table.setCustomer(null);
        table.setAccount(0);
        table.setTimer(0);
        table.setCheckExit(false);
    }

    void addTables() {
        for (int i = 0; i < tableCount; i++) {
            tables.add(new Table((i + 1), true, null, null, 0, false, 0));
        }
    }

    void checkTimerOfAllDishes(Table table) {
        boolean check = true;
        for (int i = 0; i < table.getDishes().size(); i++) {
            if (table.getDishes().get(i).isStatus()) {
                check = false;
                break;
            }
        }
        if (check) {
            table.setCheckExit(true);
            table.setTimer(30);
        }
    }


    void mainMenu() {
        addCustomerToTable(); // Добавление нового покупателя
        for (Table value : tables) {
            if (!value.isStatus()) {
                table.tableToString(value); // Вывод занятых столиков

                if (value.isCheckExit()) {
                    value.setTimer(value.getTimer() - timer); // Уменьшение таймера у столика
                    if (value.getTimer() <= -timer) {
                        System.out.println("Table № : " + table.getNumber() + " has left");
                        System.out.println("----------");
                        deleteCustomerFromTable(value); // Уаление столика
                    } else {
                        randomDeleteFromTable(value); // Удаление столика до таймера
                    }
                } else {
                    for (int j = 0; j < value.getDishes().size(); j++) {
                        if (value.getDishes().get(j).isStatus()) {
                            value.getDishes().get(j).setTimer(value.getDishes().get(j).getTimer() - timer); // Уменьшение таймера у блюда
                        }

                        if (value.getDishes().get(j).getTimer() <= 0 & value.getDishes().get(j).isStatus()) {
                            value.getDishes().get(j).setStatus(true); // Выключение таймера у блюда (ГОТОВО)
                            value.getDishes().get(j).setTimer(0);
                        }

                    }
                    checkTimerOfAllDishes(value); // Установить флаг на стол
                }


            }
        }
        randomDishToRandomCustomer(); // Добавления блюда (рандом)
    }

    void randomDeleteFromTable(Table table) {
        int random = (int) (Math.random() * 10);

        if (random / randomOfDeleteFromTable >= 1) {
            System.out.println("Table №: " + table.getNumber() + "Paid the bill and arrived early !");
            System.out.println("----------");
            deleteCustomerFromTable(table);
        }
    }

    void randomDishToRandomCustomer() {
        int random = (int) (Math.random() * 10);

        if (random / randomOfCreateNewDish >= 1) {
            int randomDish = (int) (Math.random() * dishes.length);
            int randomTable = (int) (Math.random() * tableCount);

            if (!tables.get(randomTable).isStatus()) {
                if (tables.get(randomTable).getDishes().size() < maxDishes) {
                    tables.get(randomTable).getDishes().add(dishes[randomDish]);
                    tables.get(randomTable).setTimer(0);
                    tables.get(randomTable).setCheckExit(false);
                    tables.get(randomTable).setAccount(tables.get(randomTable).getAccount() + dishes[randomDish].getCost());
                }

            }

        }

    }
}
