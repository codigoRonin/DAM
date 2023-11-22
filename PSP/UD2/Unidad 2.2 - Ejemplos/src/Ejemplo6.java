public class Ejemplo6 {
    public static void main(String[] args) {
        SharedDataSynchronized sd = new SharedDataSynchronized();
        ProducerSynchronized p = new ProducerSynchronized(sd);
        ConsumerSynchronized c = new ConsumerSynchronized(sd);
        p.start();
        c.start();
    }
}