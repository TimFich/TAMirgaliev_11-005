

public class Person implements Comparable<Person>, Printable {
    String nameOfPerson;
    int age;

    public Person(String name, int age) {
        this.nameOfPerson = name;
        this.age = age;
    }

    @Override
    public void print() {
        System.out.println(nameOfPerson + " " + age);
    }

    @Override
    public int compareTo(Person per) {
        return nameOfPerson.compareTo(per.nameOfPerson);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + nameOfPerson + '\'' +
                ", age=" + age +
                '}';
    }


}

