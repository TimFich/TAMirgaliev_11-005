package Task_1;

import java.io.*;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Writer writer = new Writer();
        Reader reader = new Reader();
        for (int i = 0; i < 100; i++) {
            writer.run();
            writer.join();
            reader.run();
            reader.join();
        }
    }

    static class Writer extends Thread {
        @Override
        public void run() {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src//Task_1//person.txt"))) {
                Person person = PersonCreator.creator();
                objectOutputStream.writeObject(person);
                System.out.println("Writer working ....");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Reader extends Thread {
        @Override
        public void run() {
            try (ObjectInputStream inputStreamReader = new ObjectInputStream(new FileInputStream("src//Task_1//person.txt"))) {
                Person person = (Person) inputStreamReader.readObject();
                System.out.println(person);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
