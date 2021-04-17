package Third_Task;

import java.util.Iterator;

public class FibonacciRange implements Iterable<Integer> {
    protected int length;
    protected int count;

    public FibonacciRange(int length) {
        this.length = length;
        this.count = 0;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count < length;
            }

            @Override
            public Integer next() {
                return count++;
            }
        };
    }
}
