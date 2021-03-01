public class LinkedList<T> {


    static class Node<T> {
        private T value;
        private Node next;
    }

    private Node<T> head;

    void add(T item) {
        Node<T> tNode = new Node<>();

        tNode.value = item;
        if (head == null) {
            head = tNode;
            return;
        }

        Node thead = head;
        while (thead.next != null) {
            thead = thead.next;
        }
        thead.next = tNode;
    }

    T get(int i) {
        Node<T> thead = head;
        int counter = 0;
        T temp = null;
        while (thead != null) {
            if (counter == i) {
                temp = thead.value;
            }
            thead = thead.next;
            counter++;
        }
        return temp;
    }

    int count() {
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    void remove(int i) {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            /*if ((i == 0) & (counter == 0)) {
                temp = ;
            }*/
            if ((counter + 1) == i) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
            counter++;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        System.out.println(linkedList.count());
        linkedList.remove(1);
        linkedList.remove(2);
        for (int i = 0; i < linkedList.count(); i++) {
            System.out.println(linkedList.get(i));
        }

    }
}
