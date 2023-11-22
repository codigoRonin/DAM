public class CounterDecRunnable implements Runnable {
    private Counter c;

    public CounterDecRunnable(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            c.decrement();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Finishing dec. Final value = " + c.getValue());
    }
}
