public class CounterSynchronized {
    int value;

    public CounterSynchronized(int value) {
        this.value = value;
    }

    public synchronized void increment() {
        value++;
    }

    public synchronized void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }
}