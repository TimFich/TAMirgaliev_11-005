package Task_1;

import java.io.Serializable;

public class Person implements Serializable {
    private Names name;
    private int age;
    private Countries country;

    public Person(Names name, int age, Countries country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country=" + country +
                '}';
    }
}
