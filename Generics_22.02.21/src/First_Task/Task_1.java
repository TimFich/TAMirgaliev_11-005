package First_Task;

import java.util.Scanner;

public class Task_1 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        FourTuple<Integer, Integer, Integer, Integer> fourTuple = makeFourValues();
        System.out.println(fourTuple.first);
        System.out.println(fourTuple.second);
        System.out.println(fourTuple.third);
        System.out.println(fourTuple.fourth);
    }

    public static FourTuple<Integer, Integer, Integer, Integer> makeFourValues() {
        return new FourTuple<>(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
    }
}
