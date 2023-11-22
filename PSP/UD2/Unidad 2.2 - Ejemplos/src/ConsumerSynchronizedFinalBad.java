public class ConsumerSynchronizedFinalBad extends Thread {
    SharedDataSyncronizedFinalBad data;

    public ConsumerSynchronizedFinalBad(SharedDataSyncronizedFinalBad data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
// Tambien podriamos meter la logica en un bloque sincronizado
            // synchronized (data) {
            //     int n = data.get();
            //     System.out.println("Consumed number " + n);
            // }
            int n = data.get();
            System.out.println("Consumed number " + n);
            try {
                Thread.sleep(15);
            } catch (Exception e) {
            }
        }
    }
}