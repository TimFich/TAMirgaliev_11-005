import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CRUD<T extends Comparable<T> & Printable> {
    ArrayList<T> tArrayList = new ArrayList<>();

    public void create(T item) throws IllegalArgumentException {
        for (T x : tArrayList) {
            if (x.compareTo(item) == 0) {
                throw new IllegalArgumentException("This element is already be in array");
            }
        }
        tArrayList.add(item);
    }

    public T read(int id) throws NoSuchElementException {
        int i = -1;
        for (T x : tArrayList) {
            i++;
            if (i == id)
                return x;
        }
        throw new NoSuchElementException("сосать+лежать");
    }

    public void update(T item) throws NoSuchElementException {
        for (int i = 0; i < tArrayList.size(); i++) {
            if (tArrayList.get(i).compareTo(item) == 0) {
                tArrayList.set(i, item);
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public void delete(T item) throws NoSuchElementException {
        for(int i = 0; i< tArrayList.size(); i++) {
            if (tArrayList.get(i).compareTo(item)==0) {
                tArrayList.remove(i);
                return;
            }
        }
        throw new NoSuchElementException("сосать+лежать");
    }
}


