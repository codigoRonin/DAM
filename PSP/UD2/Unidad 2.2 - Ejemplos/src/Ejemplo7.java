public class Ejemplo7 {
    public static void main(String[] args) {
        SharedDataSynchronizedFinal sd = new SharedDataSynchronizedFinal();
        ProducerSynchronizedFinal p = new ProducerSynchronizedFinal(sd);
        ConsumerSynchronizedFinal c = new ConsumerSynchronizedFinal(sd);
        p.start();
        c.start();
    }
  
}
