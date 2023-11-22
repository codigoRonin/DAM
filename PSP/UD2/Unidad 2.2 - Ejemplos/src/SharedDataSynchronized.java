public class SharedDataSynchronized {

    int data;

    public synchronized int get() {
        return data;
    }

    public synchronized void put(int newData) {
        data = newData;
    }
}
