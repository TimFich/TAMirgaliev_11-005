package Task_1;

public class PersonCreator {

    public static Person creator() {
        Names name = Names.values()[(int) (Math.random() * Names.values().length)];
        int age = (int) (Math.random() * 100);
        Countries countries = Countries.values()[(int) (Math.random() * Countries.values().length)];
        Person person = new Person(name, age, countries);
        return person;
    }
}
