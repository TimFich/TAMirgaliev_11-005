public class Main {
    public static void main(String[] args) {
        CRUD<Person> personCRUD = new CRUD<>();
        personCRUD.create(new Person("Oleg",24));
        personCRUD.create(new Person("Dima",45));
        personCRUD.create(new Person("Vlad",56));
        personCRUD.create(new Person("Leva",27));

        personCRUD.delete(new Person("Leva",27));

        personCRUD.update(new Person("Oleg",24));

        System.out.println(personCRUD.read(1));

        for (Person x: personCRUD.tArrayList){
            x.print();
        }
    }
}
