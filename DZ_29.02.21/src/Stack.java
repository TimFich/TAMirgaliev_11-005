import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    static class Node<T> {
        private T value;
        private Node next;
    }

    private Node<T> head;

    public void push(T value) {
        Node<T> tNode = new Node<>();
        tNode.value = value;
        tNode.next = head;
        head = tNode;
    }


    public T pop() {
        T temp;
        temp = head.value;
        head = head.next;
        return temp;
    }

    public T peek() {
        return head.value;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(30);
        stack.push(40);
        for (Integer item : stack) {
            System.out.println(item);
        }
        for (Integer item : stack) {
            System.out.println(item);
        }
    }

    class StackIterator implements Iterator<T> {
        Node temp1 = head;

        @Override
        public boolean hasNext() {
            if (head != null) {
                return true;
            } else {
                head = temp1;
                return false;
            }
        }

        @Override
        public T next() {
            T item = head.value;
            head = head.next;
            return item;
        }
    }
}

