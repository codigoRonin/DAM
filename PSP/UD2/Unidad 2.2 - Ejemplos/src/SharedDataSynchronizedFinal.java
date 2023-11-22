public class SharedDataSynchronizedFinal {
    int data;
    boolean available = false;

    public synchronized int get() {
        if (!available)
            try {
                wait();
            } catch (Exception e) {
            }
        available = false;
        notify();
        return data;
    }

    public synchronized void put(int newData) {
        if (available)
            try {
                wait();
            } catch (Exception e) {
            }
        data = newData;
        available = true;
        notify();
    }
}