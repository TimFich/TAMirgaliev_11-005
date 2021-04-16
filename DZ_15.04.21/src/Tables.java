public class Tables {
    int count;
    String nameOfBooker;

    public Tables(int count, String nameOfBooker) {
        this.count = count;
        this.nameOfBooker = nameOfBooker;
    }

    @Override
    public String toString() {
        return "count=" + count +
                ", nameOfBooker='" + nameOfBooker + '\'' +
                '}';
    }
}
