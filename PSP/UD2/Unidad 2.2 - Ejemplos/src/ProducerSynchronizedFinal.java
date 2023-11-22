public class ProducerSynchronizedFinal extends Thread {
    SharedDataSynchronizedFinal data;

    public ProducerSynchronizedFinal(SharedDataSynchronizedFinal data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            data.put(i);
            System.out.println("Produced number " + i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}