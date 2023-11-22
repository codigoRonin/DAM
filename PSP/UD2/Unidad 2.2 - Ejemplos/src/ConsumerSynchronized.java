public class ConsumerSynchronized extends Thread {
    SharedDataSynchronized data;

    public ConsumerSynchronized(SharedDataSynchronized data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            int n = data.get();
            System.out.println("Consumed number " + n);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}